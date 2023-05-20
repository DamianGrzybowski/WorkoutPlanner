package pl.coderslab.WorkoutPlanner.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Getter
public class CurrentUser extends User {
    private final pl.coderslab.WorkoutPlanner.entity.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.WorkoutPlanner.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
}
