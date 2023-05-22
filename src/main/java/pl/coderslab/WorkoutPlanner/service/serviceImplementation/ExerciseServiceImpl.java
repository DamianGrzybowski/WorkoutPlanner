package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.DayPlan;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.repository.ExerciseRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.ExerciseServis;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseServis {
    private final ExerciseRepository exerciseRepository;

    @Override
    public Exercise findByName(String name) {
        return exerciseRepository.findByName(name);
    }

    @Override
    public Exercise findByType(String type) {
        return exerciseRepository.findByType(type);
    }

    @Override
    public Exercise findByUserId(Long id) {
        return exerciseRepository.findByUserId(id);
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);

    }

    @Override
    public void update(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public List<Exercise> findAllByUserId(Long id) {
        return exerciseRepository.findAllByUserId(id);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public List<Exercise> findAllByDayPlanId(Long id) {
        return exerciseRepository.findAllByDayPlanId(id);
    }


}
