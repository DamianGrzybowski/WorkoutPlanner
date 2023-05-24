package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;
import java.util.Optional;

public interface DayPlanService {
    List<DayPlan> findByTrainingPlanId(Long id);
    DayPlan findByDay(String day);

    List<DayPlan> findAllByUser(User user);

    List<String> allDays();

    void save(DayPlan dayPlan);

    void update(DayPlan dayPlan);

    void delete(Long id);

    Optional<DayPlan> findById(Long id);

}
