package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.CurrentUser;
import pl.coderslab.WorkoutPlanner.entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

    void update(User user);

    void delete(Long id);

    boolean verifyPassword(String password, CurrentUser user);

    User findByEmail(String email);
}
