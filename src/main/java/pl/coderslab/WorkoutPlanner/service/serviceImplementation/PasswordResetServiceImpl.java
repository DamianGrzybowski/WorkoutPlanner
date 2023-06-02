package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.PasswordResetTokenRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.PasswordResetService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PasswordResetServiceImpl implements PasswordResetService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void save(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public PasswordResetToken findByUser(User user) {
        return passwordResetTokenRepository.findByUser(user);
    }

    @Override
    public void delete(PasswordResetToken token) {
        passwordResetTokenRepository.delete(token);
    }

    @Override
    public boolean isExpired(LocalDateTime expireDate) {
        LocalDateTime now = LocalDateTime.now();
        return expireDate.isBefore(now);
    }


}
