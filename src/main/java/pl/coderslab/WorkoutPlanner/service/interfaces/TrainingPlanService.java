package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanService {

    void save(TrainingPlan trainingPlan);

    void update(TrainingPlan trainingPlan);

    void delete(Long id);

    TrainingPlan findByName(String name);

    TrainingPlan findByUser(User user);

    List<TrainingPlan> findAll();


    Optional<TrainingPlan> findById(Long id);
}
