package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.RoleService;
import ru.job4j.forum.service.UserService;

import java.util.Optional;

@Controller
public class RegControl {
    private final PasswordEncoder encoder;
    private final UserService userService;
    private final RoleService roleService;

    public RegControl(PasswordEncoder encoder, UserService userService, RoleService roleService) {
        this.encoder = encoder;
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(roleService.findRoleById(2).get());
        user.setEnabled(true);
        boolean rsl = userService.create(user);
        if (!rsl) {
            model.addAttribute("errorMessage", "Username is exist");
            return "reg";
        }
        return "login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
