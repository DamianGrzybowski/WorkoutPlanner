package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.User;

import javax.transaction.Transactional;

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
