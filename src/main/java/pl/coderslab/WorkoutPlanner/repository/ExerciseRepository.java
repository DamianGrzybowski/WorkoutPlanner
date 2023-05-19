package pl.coderslab.WorkoutPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.Exercise;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByName(String name);

    Exercise findByType(String type);
}

