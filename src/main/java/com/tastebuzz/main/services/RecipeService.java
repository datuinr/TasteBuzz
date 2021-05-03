package com.tastebuzz.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tastebuzz.main.models.Recipe;
import com.tastebuzz.main.repositories.RecipeRepository;

@Service
public class RecipeService {
	private final RecipeRepository recipeRepository;
	
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	//create
	public Recipe addRecipe(Recipe r) {
		return recipeRepository.save(r);
	}
	
	//read - find by id
	public Recipe findById(Long id) {
		Optional<Recipe> findRecipe = recipeRepository.findById(id);
		if(findRecipe.isPresent()) {
			return findRecipe.get();
		} else {
			return null;
		}
	}
	
	//read - find all
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}
	
	//update
	public Recipe updateRecipe(Recipe r) {
		return recipeRepository.save(r);
	}
	
	//delete
	public void delete(Long id) {
		recipeRepository.deleteById(id);
	}
	
	//search by recipe
	public List<Recipe> findNameOfRecipe(String string) {
		return recipeRepository.findByNorContaining(string);
	}
}
