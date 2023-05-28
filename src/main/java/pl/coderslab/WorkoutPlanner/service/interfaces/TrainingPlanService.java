package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanService {

    void save(TrainingPlan trainingPlan);

    void update(TrainingPlan trainingPlan);

    void delete(Long id);


    List<TrainingPlan> findAll();


    Optional<TrainingPlan> findById(Long id);


    List<TrainingPlan> findAllByUser(User user);

    TrainingPlan findLatestPlan(Long id);
}
