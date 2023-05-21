package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("dayplan/details")
    public String details(@RequestParam("id") Long id, Model model) {
        DayPlan dayPlan = dayPlanService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid day plan id: " + id));
        model.addAttribute("dayPlanDetails", dayPlan);
        List<Exercise> exercises = exerciseServis.findAllByDayPlanId(dayPlan.getId());
        model.addAttribute("exercises", exercises);
        return "dayPlan-details";
    }

    @GetMapping("dayplan/update")
    public String update(@RequestParam("id") Long id, Model model) {
        DayPlan dayPlanToUpdate = dayPlanService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid day plan id: " + id));
        model.addAttribute("dayPlanToUpdate", dayPlanToUpdate);
        List<Exercise> exercises = exerciseServis.findAll();
        model.addAttribute("exercises", exercises);
        List<TrainingPlan> plans = planService.findAll();
        model.addAttribute("plans", plans);
        List<String> days = dayPlanService.allDays();
        model.addAttribute("days", days);


        return "dayPlan-update";
    }

    @PostMapping("dayplan/update")
    public String update(@ModelAttribute("dayPlanToUpdate") @Valid DayPlan dayPlan, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "dayPlan-update";
        }
        dayPlan.setUser(user.getUser());
        dayPlanService.update(dayPlan);
        return "redirect:/home/dayplans";
    }

    @GetMapping("dayplan/delete")
    public String delete(@RequestParam("id") Long id) {
        dayPlanService.delete(id);
        return "redirect:/home/dayplans";
    }


}
