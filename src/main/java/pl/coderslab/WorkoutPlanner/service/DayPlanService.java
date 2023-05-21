package pl.coderslab.WorkoutPlanner.service;

import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;

import java.util.List;

public interface DayPlanService {
    List<DayPlan> findByTrainingPlan(TrainingPlan trainingPlan);
    DayPlan findByDay(String day);
}
