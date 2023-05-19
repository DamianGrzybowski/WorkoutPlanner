package pl.coderslab.WorkoutPlanner.service;

import pl.coderslab.WorkoutPlanner.entity.User;

public interface UserService {
    User findByEmail(String email);

    User findByUserId(Long id);

    void saveUser(User user);

    void update(User user);

    void delete(Long id);
}
