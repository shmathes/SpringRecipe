package com.github.shmathes.Recipe_App.services;

import com.github.shmathes.Recipe_App.model.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getRecipes();
}
