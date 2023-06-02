package pl.coderslab.WorkoutPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.EmailToken;
import pl.coderslab.WorkoutPlanner.entity.User;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<EmailToken, Long> {
    EmailToken findByToken(String token);

    EmailToken findByUser(User user);

}
