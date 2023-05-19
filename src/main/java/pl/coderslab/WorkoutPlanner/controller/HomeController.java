package pl.coderslab.WorkoutPlanner.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.WorkoutPlanner.service.TrainingPlanService;
import pl.coderslab.WorkoutPlanner.service.UserService;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class HomeController {
    private final UserService userService;
    private final TrainingPlanService planService;

    @GetMapping()
    public String home(Model model) {


    }
}
