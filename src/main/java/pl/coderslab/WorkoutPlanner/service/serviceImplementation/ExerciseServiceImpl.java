package pl.coderslab.WorkoutPlanner.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.repository.ExerciseRepository;
import pl.coderslab.WorkoutPlanner.service.interfaces.ExerciseService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;


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
