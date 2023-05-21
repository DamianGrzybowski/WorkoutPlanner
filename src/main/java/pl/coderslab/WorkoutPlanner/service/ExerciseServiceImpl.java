package pl.coderslab.WorkoutPlanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.WorkoutPlanner.entity.Exercise;
import pl.coderslab.WorkoutPlanner.repository.ExerciseRepository;

import javax.transaction.Transactional;
import java.util.List;

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
}
