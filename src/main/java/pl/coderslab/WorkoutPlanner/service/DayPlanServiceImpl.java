package pl.coderslab.WorkoutPlanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.TrainingPlan;
import pl.coderslab.WorkoutPlanner.repository.DayPlanRepository;

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
}
