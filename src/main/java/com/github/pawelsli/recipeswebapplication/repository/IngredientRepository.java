package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Ingredient;
import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>, JpaSpecificationExecutor<Ingredient> {

    @SuppressWarnings("serial")
    static Specification<Ingredient> multiLikeColumn(List<String> likePatterns){
        return (Specification<Ingredient>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> titleColumn= root.get("title");
            List<Predicate> predicates = likePatterns.stream()
                    .map(likePattern ->{
                        return criteriaBuilder.like(titleColumn,likePattern) ;
                    })
                    .collect(Collectors.toList());
            return criteriaBuilder.or(predicates.toArray(new Predicate[]{}));
        };
    }
}
