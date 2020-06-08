package com.github.shmathes.Recipe_App.repositories;

import com.github.shmathes.Recipe_App.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{

}
