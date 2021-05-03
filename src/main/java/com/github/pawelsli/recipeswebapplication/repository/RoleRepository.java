package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.ERole;
import com.github.pawelsli.recipeswebapplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
