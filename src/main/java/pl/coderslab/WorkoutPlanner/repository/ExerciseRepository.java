package pl.coderslab.WorkoutPlanner.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.Exercise;

import java.util.List;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByName(String name);

    Exercise findByType(String type);

    Exercise findByUserId(Long id);

    List<Exercise> findAllByUserId(Long id);

    @Query("select e from Exercise e left join e.dayPlans d WHERE d.id = ?1")
    List<Exercise> findAllByDayPlanId(Long id);

}

