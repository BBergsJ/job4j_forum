package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenEdit() throws Exception {
        when(posts.findPostById(0)).thenReturn(Optional.of(new Post()));

        this.mockMvc.perform(get("/edit").param("id", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenPost() throws Exception {
        Post post = Post.of("Куплю ладу-грант. Дорого.", "Тестовый текст");
        post.setId(1);
        when(posts.findPostById(1)).thenReturn(Optional.of(post));

        this.mockMvc.perform(get("/post").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenReg() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

}