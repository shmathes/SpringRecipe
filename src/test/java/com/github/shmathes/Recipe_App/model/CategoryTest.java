package com.github.shmathes.Recipe_App.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before //Create new category before each test method is run
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() throws Exception
    {
        Long idValue = 4L;
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception
    {
        category.setDescription("Cruncy Taco");
        assertEquals("Cruncy Taco", category.getDescription());
    }

    @Test
    public void getRecipes() throws Exception
    {
    }
}