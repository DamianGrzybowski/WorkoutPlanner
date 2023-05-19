package pl.coderslab.WorkoutPlanner.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.TrainingPlanRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
    TrainingPlanRepository planRepository;

    @Override
    public TrainingPlan findByName(String name) {
        return planRepository.findByName(name);
    }

    @Override
    public TrainingPlan findByUser(User user) {
        return planRepository.findByUser(user);
    }
}
