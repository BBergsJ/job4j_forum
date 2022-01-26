package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Roles;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.RoleService;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ForumMem {
    private final HashMap<Integer, Post> posts = new HashMap<>();
    private final HashMap<Integer, Roles> roles = new HashMap<>();
    private final HashMap<Integer, User> users = new HashMap<>();
    private final static AtomicInteger ID_POST = new AtomicInteger(4);
    private final static AtomicInteger ID_USER = new AtomicInteger(4);

    public ForumMem() {
        Post post1 = Post.of("Продаю машину ладу 01.", "Продаю машину ладу 01.");
        Post post2 = Post.of("Продаю машину ладу 02.", "Продаю машину ладу 02.");
        Post post3 = Post.of("Продаю машину ладу 03.", "Продаю машину ладу 03.");
        post1.setId(1);
        post2.setId(2);
        post3.setId(3);
        posts.put(1, post1);
        posts.put(2, post2);
        posts.put(3, post3);
        roles.put(1, Roles.of("ROLE_USER"));
        roles.put(2, Roles.of("ROLE_ADMIN"));
    }

    public void addPost(Post post) {
        if (post.getId() == 0) {
            post.setId(ID_POST.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    public List<Roles> getAllRoles() {
        return new ArrayList<>(roles.values());
    }

    public boolean addUser(User user) {
        boolean rsl = false;
        if (findUserByName(user.getUsername()) == null) {
            user.setId(ID_USER.incrementAndGet());
            user.setEnabled(true);
            user.setRole(findRoleById(1));
            users.put(user.getId(), user);
            rsl = true;
        }
        return rsl;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> findUserById(int id) {
        return Optional.of(users.get(id));
    }

    public Optional<User> findUserByName(String name) {
        return users.values().stream().filter(u -> u.getUsername().equals(name)).findFirst();
    }

    public Roles findRoleById(int id) {
        return roles.get(id);
    }

    public Optional<Post> findPostById(int id) {
        return Optional.of(posts.get(id));
    }
}
