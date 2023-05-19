package pl.coderslab.WorkoutPlanner.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "user")
public class User {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";
    private static final String SIZE_MESSAGE = "Please enter text between 5 and 30 characters";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 5, max = 30, message = SIZE_MESSAGE)
    private String firstName;


    @Column(name = "last_name")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 5, max = 30, message = SIZE_MESSAGE)
    private String lastName;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user")
    private List<TrainingPlan> trainingPlans = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}