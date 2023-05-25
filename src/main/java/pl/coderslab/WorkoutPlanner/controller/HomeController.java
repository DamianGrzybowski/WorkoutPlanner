package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequiredArgsConstructor
public class HomeController {
    private final TrainingPlanService planService;
    private final DayPlanService dayPlanService;

    @GetMapping("home")
    public String home(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        TrainingPlan latestPlan = planService.findLatestPlan(user.getId());
        model.addAttribute("planDetails", latestPlan);
        List<DayPlan> dayPlans = dayPlanService.findByTrainingPlanId(latestPlan.getId());
        model.addAttribute("dayPlans", dayPlans);

        return "home";
    }

    @GetMapping("logout")
    public String logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/login";
    }
}
