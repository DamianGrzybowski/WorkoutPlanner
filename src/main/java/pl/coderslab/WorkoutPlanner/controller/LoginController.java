package pl.coderslab.WorkoutPlanner.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.WorkoutPlanner.entity.User;

@Controller
@Transactional
@RequiredArgsConstructor
public class LoginController {


    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


}
