package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.TrainingPlanRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.TrainingPlanService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {
    private final TrainingPlanRepository planRepository;

    @Override
    public void save(TrainingPlan trainingPlan) {
        planRepository.save(trainingPlan);
    }

    @Override
    public void update(TrainingPlan trainingPlan) {
        planRepository.save(trainingPlan);
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public List<TrainingPlan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Optional<TrainingPlan> findById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public List<TrainingPlan> findAllByUser(User user) {
        return planRepository.findAllByUser(user);
    }

    @Override
    public TrainingPlan findLatestPlan(Long id) {
        return planRepository.findLatestPLan(id);
    }
}
