package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;

public interface PasswordResetService {
    void save(PasswordResetToken passwordResetToken);

    String generateToken();

}
