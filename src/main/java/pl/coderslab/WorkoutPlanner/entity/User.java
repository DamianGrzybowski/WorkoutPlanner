package pl.coderslab.WorkoutPlanner.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Transactional
@Table(name = "user")
public class User {
    private static final String NOT_EMPTY_MESSAGE = "The field cannot be empty";
    private static final String SIZE_MESSAGE = "Please enter text between 5 and 30 characters";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Size(min = 5, max = 30, message = SIZE_MESSAGE)
    private String username;


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