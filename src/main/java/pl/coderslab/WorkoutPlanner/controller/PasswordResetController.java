package pl.coderslab.WorkoutPlanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.WorkoutPlanner.entity.EmailToken;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.EmailTokenService;
import pl.coderslab.WorkoutPlanner.service.interfaces.UserService;
import pl.coderslab.WorkoutPlanner.service.serviceImplementation.EmailSenderServiceImpl;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class PasswordResetController {
    private final UserService userService;
    private final EmailSenderServiceImpl mailService;
    private final EmailTokenService tokenService;

    @GetMapping("password_reset")
    public String resetPassword() {
        return "reset-password-email";
    }


    @PostMapping("password_reset")
    public String resetPasswordForm(@RequestParam("userEmail") String email) throws MessagingException {
        User user = userService.findByEmail(email);
        if (user == null || user.getEmailEnabled() == 0) {
            return "reset-password-email";
        }
        mailService.sendResetMail(user);
        return "mailSend";
    }

    @GetMapping("reset")
    public String reset(@RequestParam("token") String token, Model model) {
        EmailToken resetToken = tokenService.findByToken(token);
        if (resetToken == null || tokenService.isExpired(resetToken.getExpiryDate())) {
            return ResponseEntity.notFound().toString();
        }
        User user = resetToken.getUser();
        model.addAttribute("user", user);
        return "password-reset-form";
    }

    @PostMapping("reset")
    public String reset(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "password-reset-form";
        }
        if (user.getPassword().equals(user.getConfirmPassword())) {
            userService.update(user);
            tokenService.delete(tokenService.findByUser(user));
        } else {
            return "password-reset-form";
        }

        return "redirect:/login";
    }

}
