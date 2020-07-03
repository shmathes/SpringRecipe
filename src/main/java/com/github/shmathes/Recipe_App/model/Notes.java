package com.github.shmathes.Recipe_App.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "recipe")
@Data
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

}
