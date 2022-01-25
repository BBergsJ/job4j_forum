package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Roles;

public interface RoleRepository extends CrudRepository<Roles, Integer> {
}