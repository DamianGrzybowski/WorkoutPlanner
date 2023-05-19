package pl.coderslab.WorkoutPlanner.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "training_plan")
public class TrainingPlan {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "trainingPlan")
    private List<DayPlan> dayPlans = new ArrayList<>();


}