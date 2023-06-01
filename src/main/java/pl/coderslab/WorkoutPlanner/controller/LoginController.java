package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.PasswordResetService;
import pl.coderslab.WorkoutPlanner.service.interfaces.UserService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Controller
@Transactional
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final PasswordResetService passwordService;


    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("password_reset")
    public String resetPassword() {
        return "reset-password-email";
    }

    @PostMapping("password_reset")
    public String resetPasswordForm(@RequestParam("userEmail") String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return "reset-password-email";
        }
        String token = passwordService.generateToken();
        LocalDateTime expireDate = LocalDateTime.now().plusHours(2);

        passwordService.save(new PasswordResetToken(token, user, expireDate));

        String resetPasswordLink = "http://localhost:8080/reset?token=" + token;


        return "redirect:/login";
    }


}
