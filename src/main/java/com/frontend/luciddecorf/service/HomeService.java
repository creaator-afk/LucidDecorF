package com.frontend.luciddecorf.service;

import com.frontend.luciddecorf.model.User;
import com.frontend.luciddecorf.model.UserType;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {
    List<User> users = Arrays.asList(
            new User(1, "Kshitij", UserType.LEARNER),
            new User(2, "Tiwari", UserType.INSTRUCTOR),
            new User(3, "Ravi", UserType.ADMIN),
            new User(4, "Utkarsh", UserType.INSTRUCTOR),
            new User(4, "Subham", UserType.INSTRUCTOR)
    );

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        Optional<User> user = this.users.stream().filter(user1 -> user1.getId() == id).findAny();
        return user.orElseGet(User::new);
    }

}
