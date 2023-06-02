package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.EmailToken;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.service.interfaces.EmailTokenService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl {
    private final JavaMailSender mailSender;
    private final EmailTokenService passwordService;


    public void sendResetMail(User user) throws MessagingException {
        String token = passwordService.generateToken();
        LocalDateTime expireDate = LocalDateTime.now().plusHours(2);

        passwordService.save(new EmailToken(token, user, expireDate));

        String resetPasswordLink = "http://localhost:8080/reset?token=" + token;
        String message = "<p>Dear " + user.getUsername() + ",</p>"
                + "<p>Please click on the following link to reset your password:</p>"
                + "<p><a href=\"" + resetPasswordLink + "\">Reset Password</a></p>"
                + "<p>If you didn't request a password reset, please ignore this email.</p>"
                + "<p>Best regards,<br>Your WorkoutPlanner Team</p>";
        String subject = "WorkoutPlanner - Password reset";


            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message, true);
            mailSender.send(mimeMessage);
    }
    public void sendConfirmMail(User user) throws MessagingException {
        String token = passwordService.generateToken();
        LocalDateTime expireDate = LocalDateTime.now().plusDays(7);

        passwordService.save(new EmailToken(token, user, expireDate));

        String confirmAccountLink = "http://localhost:8080/confirmRegistration?token=" + token;
        String message = "<p>Dear " + user.getUsername() + ",</p>"
                + "<p>Please click on the following link to confirm your account:</p>"
                + "<p><a href=\"" + confirmAccountLink + "\">Confirm registration</a></p>"
                + "<p>Best regards,<br>Your WorkoutPlanner Team</p>";
        String subject = "WorkoutPlanner - Confirm registration";


        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message, true);
        mailSender.send(mimeMessage);
    }
}
