package com.github.shmathes.Recipe_App.model;

import javax.persistence.*;

@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob //Expects to store in a CLOB field
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getNotes() {
        return recipeNotes;
    }

    public void setNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
