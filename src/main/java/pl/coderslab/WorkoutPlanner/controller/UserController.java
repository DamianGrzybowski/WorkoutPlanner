package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

    @GetMapping("user/update")
    public String update(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", currentUser.getUser());
        return "user-update";
    }

    @PostMapping("user/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-update";
        }
        if (user.getPassword().equals(user.getConfirmPassword())) {
            userService.update(user);
        } else {
            return "user-update";
        }
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/login";
    }

    @GetMapping("user/accept_d")
    public String acceptDelete() {
        return "user-delete-accept";
    }

    @GetMapping("user/confirm_d")
    public String confirmDelete(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", currentUser.getUser());
        return "user-delete-confirm";
    }

    @PostMapping("user/confirm_d")
    public String confirmDelete(@ModelAttribute("user") User user, @AuthenticationPrincipal CurrentUser currentUser) {
        if (userService.verifyPassword(user.getPassword(), currentUser)) {
            return "redirect:/home/user/delete";
        }
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/login";

    }

    @GetMapping("user/delete")
    public String delete(@AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        userService.delete(user.getId());
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/register";
    }
}
