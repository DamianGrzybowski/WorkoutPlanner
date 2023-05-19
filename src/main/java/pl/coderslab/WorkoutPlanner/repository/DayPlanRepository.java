package pl.coderslab.WorkoutPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;


@Repository
public interface DayPlanRepository extends JpaRepository<DayPlan, Long> {
    DayPlan findByName(String name);

    DayPlan findByDay(String day);


}