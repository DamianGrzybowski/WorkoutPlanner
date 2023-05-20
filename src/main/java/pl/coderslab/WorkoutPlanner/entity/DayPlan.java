package pl.coderslab.WorkoutPlanner.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "day_plan")
public class DayPlan {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";
    private static final String SIZE_MESSAGE = "Please enter text between 3 and 30 characters";
    private static final String LARGER_SIZE_MESSAGE = "Please enter text between 3 and 255 characters";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 30, message = SIZE_MESSAGE)
    private String name;

    @Column(name = "description")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 255, message = LARGER_SIZE_MESSAGE)
    private String description;

    @Column(name = "day")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Pattern(regexp = "(?i)^(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)$",
            message = "Please enter correct day name")
    private String day;

    @ManyToMany
    @JoinTable(name = "day_plan_exercise",
            joinColumns = @JoinColumn(name = "day_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToOne
    private TrainingPlan trainingPlan;


}
