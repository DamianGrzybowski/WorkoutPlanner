package pl.coderslab.WorkoutPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;

import java.util.List;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
    TrainingPlan findByName(String name);

    TrainingPlan findByUser(User user);

    List<TrainingPlan> findAllByUser(User user);

    @Query("SELECT p FROM TrainingPlan p WHERE p.user.id = ?1 AND(p.createdOn = (SELECT MAX(p2.createdOn) FROM TrainingPlan p2 WHERE p2.user.id = ?1))")
    TrainingPlan findLatestPLan(Long id);
}
