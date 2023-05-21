package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;
import pl.coderslab.WorkoutPlanner.service.interfaces.UserService;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    private final TrainingPlanService planService;
    private final DayPlanService dayPlanService;

    @GetMapping("home")
    public String home(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);

        return "home";
    }

    @GetMapping("logout")
    public String logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/login";
    }
}
