package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Roles;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.RoleService;
import ru.job4j.forum.service.UserService;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class RegControlTest {

    @MockBean
    private UserService userService;

    @MockBean
    private RoleService roleService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageCreate() throws Exception {
        Optional<Roles> roles = Optional.of(Roles.of("ROLE_USER")) ;

        when(roleService.findRoleById(2)).thenReturn(roles);

        this.mockMvc.perform(post("/reg")
                .param("username", "user")
                .param("password", "123")
                .param("enabled", "true"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userService).create(argument.capture());
        assertThat(argument.getValue().getUsername(), is("user"));
    }
}