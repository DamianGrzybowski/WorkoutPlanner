package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.User;
import pl.coderslab.WorkoutPlanner.repository.DayPlanRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.DayPlanService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DayPlanServiceImpl implements DayPlanService {
    private final DayPlanRepository dayPlanRepository;

    @Override
    public List<DayPlan> findByTrainingPlanId(Long id) {
        List<DayPlan> trainingDays = dayPlanRepository.findByTrainingPlanId(id);
        trainingDays.sort((day1, day2) -> {
            List<String> daysOfWeek = allDays();
            Integer index1 = daysOfWeek.indexOf(day1.getDay());
            Integer index2 = daysOfWeek.indexOf(day2.getDay());
            return index1.compareTo(index2);
        });
        return trainingDays;
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

    @Override
    public Optional<DayPlan> findById(Long id) {
        return dayPlanRepository.findById(id);
    }

    @Override
    public void deleteAllByTrainingPlanId(Long id) {
        dayPlanRepository.deleteAllByTrainingPlanId(id);
    }


}
