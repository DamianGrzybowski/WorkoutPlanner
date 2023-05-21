package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;
import pl.coderslab.WorkoutPlanner.service.interfaces.ExerciseServis;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class DayPlanController {
    private final DayPlanService dayPlanService;
    private final ExerciseServis exerciseServis;
    private final TrainingPlanService planService;

    @GetMapping("dayplans")
    public String dayPlans(Model model, @AuthenticationPrincipal CurrentUser user) {
        List<DayPlan> plans = dayPlanService.findAllByUser(user.getUser());
        model.addAttribute("plans", plans);
        return "dayPlans-all";
    }

    @GetMapping("dayplan")
    public String create(Model model) {
        model.addAttribute("dayPlan", new DayPlan());
        List<Exercise> exercises = exerciseServis.findAll();
        model.addAttribute("exercises", exercises);
        List<TrainingPlan> plans = planService.findAll();
        model.addAttribute("plans", plans);
        List<String> days = dayPlanService.allDays();
        model.addAttribute("days", days);
        return "dayPlan-form";

    }

    @PostMapping("dayplan")
    public String create(@ModelAttribute("dayPlan") @Valid DayPlan dayPlan, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "dayPlan-form";
        }
        dayPlan.setUser(user.getUser());
        dayPlanService.save(dayPlan);
        return "redirect:/home/dayplans";
    }

}
