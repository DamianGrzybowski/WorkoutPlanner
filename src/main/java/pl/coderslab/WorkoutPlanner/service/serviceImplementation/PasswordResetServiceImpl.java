package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.PasswordResetToken;
import pl.coderslab.WorkoutPlanner.repository.PasswordResetTokenRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.PasswordResetService;

import javax.transaction.Transactional;
import java.util.Random;

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
        int tokenLength = 20;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder tokenBuilder = new StringBuilder();

        Random random = new Random();
        random.ints(tokenLength, 0, characters.length())
                .mapToObj(characters::charAt)
                .forEach(tokenBuilder::append);

        return tokenBuilder.toString();
    }

}
