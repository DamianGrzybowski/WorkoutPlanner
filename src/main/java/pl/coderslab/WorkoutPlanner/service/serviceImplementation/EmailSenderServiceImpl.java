package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.PasswordResetService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl {
    private final JavaMailSender mailSender;
    private final PasswordResetService passwordService;


    public void sendMail(User user) throws MessagingException {
        String token = passwordService.generateToken();
        LocalDateTime expireDate = LocalDateTime.now().plusHours(2);

        passwordService.save(new PasswordResetToken(token, user, expireDate));

        String resetPasswordLink = "http://localhost:8080/reset?token=" + token;
        String message = "<p>Dear " + user.getUsername() + ",</p>"
                + "<p>Please click on the following link to reset your password:</p>"
                + "<p><a href=\"" + resetPasswordLink + "\">Reset Password</a></p>"
                + "<p>If you didn't request a password reset, please ignore this email.</p>"
                + "<p>Best regards,<br>Your Application Team</p>";
        String subject = "WorkoutPlanner - Password reset";


            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message, true);
            mailSender.send(mimeMessage);


    }
}
