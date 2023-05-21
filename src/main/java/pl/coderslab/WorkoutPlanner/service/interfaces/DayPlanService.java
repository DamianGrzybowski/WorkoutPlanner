package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;

public interface DayPlanService {
    List<DayPlan> findByTrainingPlan(TrainingPlan trainingPlan);
    DayPlan findByDay(String day);

    List<DayPlan> findAllByUser(User user);

    List<String> allDays();

    void save(DayPlan dayPlan);

    void update(DayPlan dayPlan);

    void delete(Long id);
}
