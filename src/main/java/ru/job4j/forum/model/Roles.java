package ru.job4j.forum.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;
import java.util.Set;

public class Roles implements GrantedAuthority {
    private int id;
    private String roleName;
    private Set<User> users;

    public static Roles of(String roleName) {
        Roles role = new Roles();
        role.roleName = roleName;
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Roles roles = (Roles) o;
        return id == roles.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
