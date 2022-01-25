package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", id == 0 ? new Post() : postService.findPostById(id).get());
        return "post/edit";
    }

    @GetMapping("/post")
    public String showPost(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findPostById(id).get());
        return "post/post";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Post post) {
        if (post.getCreated() == null) {
            post.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        }
        postService.create(post);
        return "redirect:/index";
    }
}
