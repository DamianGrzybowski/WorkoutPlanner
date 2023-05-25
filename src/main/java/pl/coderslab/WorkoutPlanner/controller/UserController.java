package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.UserService;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("home")
public class UserController {
    private final UserService userService;


    @GetMapping("user")
    public String user(Model model, @AuthenticationPrincipal CurrentUser user) {
        model.addAttribute("user", user.getUser());
        return "user";
    }

    @GetMapping("user/confirm_u")
    public String confirmUpdate(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", currentUser.getUser());
        return "user-update-confirm";
    }

    @PostMapping("user/confirm_u")
    public String confirmUpdate(@ModelAttribute("user") User user, @AuthenticationPrincipal CurrentUser currentUser) {
        if (userService.verifyPassword(user.getPassword(), currentUser)) {
            return "redirect:/home/user/update";
        }
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/login";
    }
}
