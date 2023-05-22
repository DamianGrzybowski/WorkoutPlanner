package pl.coderslab.WorkoutPlanner.service.interfaces;

import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseServis {
    Exercise findByName(String name);

    Exercise findByType(String type);

    Exercise findByUserId(Long id);
    Optional<Exercise> findById(Long id);

    void save(Exercise exercise);

    void update(Exercise exercise);

    void delete(Long id);

    List<Exercise> findAllByUserId(Long id);

    List<Exercise> findAll();
    List<Exercise> findAllByDayPlanId(Long id);


}
