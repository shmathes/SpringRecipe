package com.github.shmathes.Recipe_App.bootstrap;

import com.github.shmathes.Recipe_App.model.*;
import com.github.shmathes.Recipe_App.repositories.CategoryRepository;
import com.github.shmathes.Recipe_App.repositories.RecipeRepository;
import com.github.shmathes.Recipe_App.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class BootstrapRecipes implements ApplicationListener<ContextRefreshedEvent>
{
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapRecipes(CategoryRepository categoryRepository,
                            RecipeRepository recipeRepository,
                            UnitOfMeasureRepository unitOfMeasureRepository)
    {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tspOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!tspOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tblSpoonOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tblSpoonOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        UnitOfMeasure eachUom = eachOptional.get();
        UnitOfMeasure cupUom = cupOptional.get();
        UnitOfMeasure tspUom = tspOptional.get();
        UnitOfMeasure tblSpoonUom = tblSpoonOptional.get();
        UnitOfMeasure dashUom = dashOptional.get();

        Optional<Category> americanOptional = categoryRepository.findByDescription("American");

        if(!americanOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanOptional.get();
        Category mexicanCategory = mexicanOptional.get();

        List<Recipe> recipeList = new ArrayList<>();

        log.debug("Loading Guac Recipe");

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("How to Make Perfect Guacamole Recipe");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(10);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1. Cut the avacado, remove flesh: Cut the avocados in half. Remove the pit. " +
                "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl." +
                "\n\n" +
                "2. Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunk.)" +
                "\n" +
                "3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. " +
                "The acid in the the lime juice will provide some balance to the richness of the avocado and will help delay " +
                "the avocados from turning brown" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness." +
                "So, start with a half of one chili pepper ad add to the guacamole to your desired degree of hotness." +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients." +
                "Start with this recipe and adjust to your taste." +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just" +
                "before serving" +
                "\n" +
                "4. Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the " +
                "guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes " +
                "oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("salt", new BigDecimal(.125), tspUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tblSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(.25), cupUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seed removed, minced", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tblSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), eachUom, guacRecipe));


        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");

        log.debug("Recipe finished loading");

        recipeList.add(guacRecipe);

        recipeRepository.saveAll(recipeList);

    }
}
