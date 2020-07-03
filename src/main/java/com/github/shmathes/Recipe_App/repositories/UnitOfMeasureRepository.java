package com.github.shmathes.Recipe_App.repositories;

import com.github.shmathes.Recipe_App.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>
{
    Optional<UnitOfMeasure> findByDescription(String description);
}
