package pl.coderslab.WorkoutPlanner.service;

import pl.coderslab.WorkoutPlanner.entity.Exercise;

import java.util.List;

public interface ExerciseServis {
    Exercise findByName(String name);

    Exercise findByType(String type);

    Exercise findByUserId(Long id);

    void save(Exercise exercise);

    void update(Exercise exercise);

    void delete(Long id);

    List<Exercise> findAllByUserId(Long id);
}
