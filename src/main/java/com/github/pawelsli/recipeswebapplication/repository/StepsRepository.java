package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Steps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepsRepository extends JpaRepository<Steps,Long> {
}
