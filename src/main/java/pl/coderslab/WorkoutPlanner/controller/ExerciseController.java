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
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.ExerciseServis;

import javax.transaction.Transactional;
import javax.validation.Valid;
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

}
