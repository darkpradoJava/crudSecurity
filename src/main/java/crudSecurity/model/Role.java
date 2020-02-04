package crudSecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "role")
    String role;

    public Role() {

    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

}