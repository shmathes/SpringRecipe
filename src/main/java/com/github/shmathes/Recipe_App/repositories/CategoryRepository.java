package com.github.shmathes.Recipe_App.repositories;

import com.github.shmathes.Recipe_App.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
    Optional<Category> findByDescription(String description);
}
