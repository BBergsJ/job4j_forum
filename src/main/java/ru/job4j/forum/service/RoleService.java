package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Roles;
import ru.job4j.forum.repository.ForumMem;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleService {

    private ForumMem forumMem;

    public RoleService(ForumMem forumMem) {
        this.forumMem = forumMem;
    }

    public List<Roles> getAll() {
        return forumMem.getAllRoles();
    }

    public Roles findRoleById(int id) {
        return findRoleById(id);
    }
}
