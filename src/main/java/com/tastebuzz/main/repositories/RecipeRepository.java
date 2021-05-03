package com.tastebuzz.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tastebuzz.main.models.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	List<Recipe> findAll();
	List<Recipe> findByNorContaining(String search);
}
