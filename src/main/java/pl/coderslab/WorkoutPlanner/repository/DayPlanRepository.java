package pl.coderslab.WorkoutPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface DayPlanRepository extends JpaRepository<DayPlan, Long> {

    DayPlan findByDay(String day);

    List<DayPlan> findByTrainingPlanId(Long id);

    List<DayPlan> findAllByUser(User user);

    void deleteAllByTrainingPlanId(Long id);

}