package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.TrainingPlanRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
    private final TrainingPlanRepository planRepository;

    @Override
    public TrainingPlan findByName(String name) {
        return planRepository.findByName(name);
    }

    @Override
    public TrainingPlan findByUser(User user) {
        return planRepository.findByUser(user);
    }

    @Override
    public List<TrainingPlan> findAll() {
        return planRepository.findAll();
    }
}
