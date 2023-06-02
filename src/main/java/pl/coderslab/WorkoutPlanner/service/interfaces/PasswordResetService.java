package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.time.LocalDateTime;

public interface PasswordResetService {
    void save(PasswordResetToken passwordResetToken);

    String generateToken();

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);

    void delete(PasswordResetToken token);

    boolean isExpired(LocalDateTime expireDate);

}
