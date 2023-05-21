package pl.coderslab.WorkoutPlanner.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
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

    @OneToMany
    @JoinColumn(name = "training_plan_id")
    private List<DayPlan> dayPlans = new ArrayList<>();


}