package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class TrainingPlanController {
    private final TrainingPlanService planService;
    private final DayPlanService dayPlanService;


    @GetMapping("plans")
    public String plans(Model model, @AuthenticationPrincipal CurrentUser user) {
        List<TrainingPlan> plans = planService.findAllByUser(user.getUser());
        model.addAttribute("plans", plans);
        return "plan-all";
    }

    @GetMapping("plan")
    public String create(Model model) {
        model.addAttribute("plan", new TrainingPlan());
        return "plan-form";
    }

    @PostMapping("plan")
    public String create(@ModelAttribute("plan") @Valid TrainingPlan plan, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "plan-form";
        }
        plan.setUser(user.getUser());
        planService.save(plan);
        return "redirect:/home/plans";
    }

    @GetMapping("plan/details")
    public String details(@RequestParam("id") Long id, Model model) {
        TrainingPlan plan = planService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid plan id: " + id));
        model.addAttribute("planDetails", plan);
        List<DayPlan> dayPlans = dayPlanService.findByTrainingPlanId(plan.getId());
        model.addAttribute("dayPlans", dayPlans);
        return "plan-details";
    }

    @GetMapping("plan/update")
    public String update(@RequestParam("id") Long id, Model model) {
        TrainingPlan planToUpdate = planService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid plan id: " + id));
        model.addAttribute(planToUpdate);
        return "plan-update";
    }

    @GetMapping("plan/name")
    public String updateName(@RequestParam("id") Long id, Model model) {
        TrainingPlan planName = planService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid plan id: " + id));
        model.addAttribute("planName", planName);
        return "plan-update-name";
    }

    @PostMapping("plan/name")
    public String updateName(@ModelAttribute("planName") @Valid TrainingPlan plan, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "plan-update-name";
        }
        plan.setUser(user.getUser());
        planService.save(plan);
        return "redirect:/home/plans";
    }

    @GetMapping("/plan/dayplans")
    public String readDayPlans(@RequestParam("id") Long id, Model model) {
        List<DayPlan> dayPlans = dayPlanService.findByTrainingPlanId(id);
        model.addAttribute("dayPlansByPlan", dayPlans);
        return "plan-update-dayPlans";
    }

    @GetMapping("/plan/delete/confirm")
    public String deleteConfirm(@RequestParam("id") Long id, Model model) {
        TrainingPlan plan = planService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid plan id: " + id));
        model.addAttribute("planToDelete", plan);
        return "plan-delete-confirm";
    }

    @GetMapping("plan/delete")
    public String delete(@RequestParam("id") Long id) {
        planService.delete(id);
        return "redirect:/home/plans";
    }

    @GetMapping("plan/deleteAll")
    public String deleteAll(@RequestParam("id") Long id) {
        dayPlanService.deleteAllByTrainingPlanId(id);
        planService.delete(id);
        return "redirect:/home/plans";
    }

}
