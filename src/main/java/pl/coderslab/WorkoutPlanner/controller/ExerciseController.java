package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.service.interfaces.ExerciseServis;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class ExerciseController {
    private final ExerciseServis exerciseServis;


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
        exerciseServis.save(exercise);
        return "redirect:/home";

    }

    @GetMapping("exercises")
    public String exercises(Model model, @AuthenticationPrincipal CurrentUser user) {
        List<Exercise> list = exerciseServis.findAllByUserId(user.getUser().getId());
        model.addAttribute("exercises", list);
        return "exercises-all";
    }

    @GetMapping("exercise/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Exercise exerciseToUpdate = exerciseServis.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid exercise id: " + id));
        model.addAttribute("exerciseToUpdate", exerciseToUpdate);
        return "exercise-update-form";
    }

    @PostMapping("exercise/update")
    public String update(@ModelAttribute("exerciseToUpdate") @Valid Exercise exercise, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "exercise-update-form";
        }
        exercise.setUser(user.getUser());
        exerciseServis.update(exercise);
        return "redirect:/home/exercises";
    }

    @GetMapping("/exercise/delete")
    public String delete(@RequestParam("id") Long id) {
        exerciseServis.delete(id);
        return "redirect:/home/exercises";
    }


}
