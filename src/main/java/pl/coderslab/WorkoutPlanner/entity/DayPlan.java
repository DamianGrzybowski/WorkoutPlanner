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

    @Column(name = "day")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Pattern(regexp = "(?i)^(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)$",
            message = "Please enter correct day name")
    private String day;

    @ManyToMany
    @JoinTable(
            name = "day_plan_exercise",
            joinColumns = @JoinColumn(name = "day_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;


    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
