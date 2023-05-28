package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.service.interfaces.ExerciseService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class ExerciseController {
    private final ExerciseService exerciseService;


    @GetMapping("exercise")
    public String exercise(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "exercise-form";
    }

    @PostMapping("exercise")
    public String exercise(@ModelAttribute("exercise") @Valid Exercise exercise, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "exercise-form";
        }
        exercise.setUser(user.getUser());
        exerciseService.save(exercise);
        return "redirect:/home";

    }

    @GetMapping("exercises")
    public String exercises(Model model, @AuthenticationPrincipal CurrentUser user) {
        List<Exercise> list = exerciseService.findAllByUserId(user.getUser().getId());
        model.addAttribute("exercises", list);
        return "exercises-all";
    }

    @GetMapping("exercise/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Exercise exerciseToUpdate = exerciseService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid exercise id: " + id));
        model.addAttribute("exerciseToUpdate", exerciseToUpdate);
        return "exercise-update-form";
    }

    @PostMapping("exercise/update")
    public String update(@ModelAttribute("exerciseToUpdate") @Valid Exercise exercise, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "exercise-update-form";
        }
        exercise.setUser(user.getUser());
        exerciseService.update(exercise);
        return "redirect:/home/exercises";
    }

    @GetMapping("/exercise/delete")
    public String delete(@RequestParam("id") Long id) {
        exerciseService.delete(id);
        return "redirect:/home/exercises";
    }


}
