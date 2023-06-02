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
import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@Transactional
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;
    private final EmailSenderServiceImpl mailService;
    private final EmailTokenService tokenService;

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) throws MessagingException {
        if (result.hasErrors()) {
            return "register";
        }
        if (user.getPassword().equals(user.getConfirmPassword())) {
            userService.saveUser(user);
            mailService.sendConfirmMail(user);
        } else {
            return "register";
        }
        return "email-confirm-info";
    }

    @GetMapping("/confirmRegistration")
    public String confirmRegister(@RequestParam("token") String token) {
        EmailToken resetToken = tokenService.findByToken(token);
        if (resetToken == null || tokenService.isExpired(resetToken.getExpiryDate())) {
            return ResponseEntity.notFound().toString();
        }
        User user = resetToken.getUser();
        user.setEmailEnabled(1);
        tokenService.delete(resetToken);
        return "redirect:/login";
    }
}