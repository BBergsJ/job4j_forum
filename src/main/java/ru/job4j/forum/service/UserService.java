package ru.job4j.forum.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;
import ru.job4j.forum.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public boolean create(User user) {
        boolean rsl = false;
        try {
            users.save(user);
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<User> getAll() {
        List<User> rsl = new ArrayList<>();
        users.findAll().forEach(rsl::add);
        return rsl;
    }

    public Optional<User> findUserById(int id) {
        return users.findById(id);
    }

    public Optional<User> findUserByName(String name) {
        return users.findByUsername(name);
    }

}
