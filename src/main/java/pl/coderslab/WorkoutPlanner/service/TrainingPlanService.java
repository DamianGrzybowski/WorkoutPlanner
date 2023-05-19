package pl.coderslab.WorkoutPlanner.service;

import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

public interface TrainingPlanService {
    TrainingPlan findByName(String name);

    TrainingPlan findByUser(User user);


}
