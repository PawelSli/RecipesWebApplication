package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {

    Recipe findByTitle(String name);
    List<Recipe> findAllByUser(User user);
    List<Recipe> findTop9ByOrderByLikesDesc();
    List<Recipe> findTop9ByOrderByPublicationDateDesc();
    @Query(value="SELECT * FROM recipes ORDER BY RAND() LIMIT 9", nativeQuery = true)
    List<Recipe> findRandomRecipes();

    @SuppressWarnings("serial")
    static Specification<Recipe> multiLikeColumn(List<String> likePatterns){
        return (Specification<Recipe>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> descriptionColumn= root.get("description");
            Path<String> titleColumn= root.get("title");
            List<Predicate> predicates = likePatterns.stream()
                    .map(likePattern ->{
                        return criteriaBuilder.or(criteriaBuilder.like(descriptionColumn,likePattern),
                                criteriaBuilder.like(titleColumn,likePattern));
                        //return criteriaBuilder.like(descriptionColumn,likePattern) ;
                    } )
                    .collect(Collectors.toList());
            return criteriaBuilder.or(predicates.toArray(new Predicate[]{}));
        };
    }

}

