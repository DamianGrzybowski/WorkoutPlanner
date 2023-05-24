package pl.coderslab.WorkoutPlanner.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Setter
@Getter
@Transactional
@Table(name = "exercise")
public class Exercise {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";
    private static final String SIZE_MESSAGE = "Please enter text between 3 and 30 characters";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 50, message = SIZE_MESSAGE)
    private String name;

    @Column(name = "type")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 50, message = SIZE_MESSAGE)
    private String type;

    @Min(1)
    @Column(name = "sets")
    @NotNull(message = NOT_EMPTY_MESSAGE)
    private Integer sets;

    @Min(1)
    @Column(name = "reps")
    @NotNull(message = NOT_EMPTY_MESSAGE)
    private Integer reps;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "exercises")
    private List<DayPlan> dayPlans;


}