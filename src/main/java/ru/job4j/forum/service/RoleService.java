package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Roles;
import ru.job4j.forum.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository repositories;

    public RoleService(RoleRepository repositories) {
        this.repositories = repositories;
    }

    public List<Roles> getAll() {
        List<Roles> rsl = new ArrayList<>();
        repositories.findAll().forEach(rsl::add);
        return rsl;
    }

    public Optional<Roles> findRoleById(int id) {
        return repositories.findById(id);
    }
}
