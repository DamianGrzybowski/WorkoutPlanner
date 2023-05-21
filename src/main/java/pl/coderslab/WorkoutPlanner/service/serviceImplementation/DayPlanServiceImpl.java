package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.DayPlanRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DayPlanServiceImpl implements DayPlanService {
    private final DayPlanRepository dayPlanRepository;

    @Override
    public List<DayPlan> findByTrainingPlan(TrainingPlan trainingPlan) {
        return dayPlanRepository.findByTrainingPlan(trainingPlan);
    }


    @Override
    public DayPlan findByDay(String day) {
        return dayPlanRepository.findByDay(day);
    }

    @Override
    public List<DayPlan> findAllByUser(User user) {
        return dayPlanRepository.findAllByUser(user);
    }

    @Override
    public List<String> allDays() {
        return List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    }

    @Override
    public void save(DayPlan dayPlan) {
        dayPlanRepository.save(dayPlan);
    }

    @Override
    public void update(DayPlan dayPlan) {
        dayPlanRepository.save(dayPlan);
    }

    @Override
    public void delete(Long id) {
        dayPlanRepository.deleteById(id);
    }
}
