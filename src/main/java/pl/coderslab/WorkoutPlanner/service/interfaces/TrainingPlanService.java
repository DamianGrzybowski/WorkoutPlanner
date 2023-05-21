package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;

public interface TrainingPlanService {
    TrainingPlan findByName(String name);

    TrainingPlan findByUser(User user);

    List<TrainingPlan> findAll();


}
