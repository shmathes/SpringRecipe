package com.github.shmathes.Recipe_App.repositories;

import com.github.shmathes.Recipe_App.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>
{

}
