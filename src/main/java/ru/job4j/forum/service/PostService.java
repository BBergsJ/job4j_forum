package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private ForumMem forumMem;

    public PostService(ForumMem forumMem) {
        this.forumMem = forumMem;
    }

    public void create(Post post) {
        forumMem.addPost(post);
    }

    public List<Post> getAll() {
        return forumMem.getAllPosts();
    }

    public Optional<Post> findPostById(int id) {
        return forumMem.findPostById(id);
    }
}