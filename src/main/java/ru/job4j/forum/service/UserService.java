package ru.job4j.forum.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private ForumMem forumMem;

    public UserService(ForumMem forumMem) {
        this.forumMem = forumMem;
    }

    public boolean create(User user) {
        return forumMem.addUser(user);
    }

    public List<User> getAll() {
        return forumMem.getAllUsers();
    }

    public Optional<User> findUserById(int id) {
        return forumMem.findUserById(id);
    }

    public Optional<User> findUserByName(String name) {
        return forumMem.findUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = forumMem.findUserByName(s);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
