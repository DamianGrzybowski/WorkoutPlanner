package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.EmailToken;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.time.LocalDateTime;

public interface EmailTokenService {
    void save(EmailToken emailToken);

    String generateToken();

    EmailToken findByToken(String token);

    EmailToken findByUser(User user);

    void delete(EmailToken token);

    boolean isExpired(LocalDateTime expireDate);

}
