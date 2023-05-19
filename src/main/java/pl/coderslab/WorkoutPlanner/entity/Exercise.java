package pl.coderslab.WorkoutPlanner.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Transactional
@Table(name = "exercise")
public class Exercise {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";
    private static final String SIZE_MESSAGE = "Please enter text between 3 and 30 characters";
    private static final String LARGER_SIZE_MESSAGE = "Please enter text between 3 and 255 characters";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 50, message = SIZE_MESSAGE)
    private String name;

    @Column(name = "description")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 255, message = LARGER_SIZE_MESSAGE)
    private String description;

    @Column(name = "type")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 3, max = 50, message = SIZE_MESSAGE)
    private String type;

    @Min(1)
    @Column(name = "sets")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private Integer sets;

    @Min(1)
    @Column(name = "reps")
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private Integer reps;

    @ManyToMany(mappedBy = "exercises")
    private List<DayPlan> dayPlans = new ArrayList<>();


}