package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDetailsRepository extends JpaRepository<UsersDetails,Long> {
}
