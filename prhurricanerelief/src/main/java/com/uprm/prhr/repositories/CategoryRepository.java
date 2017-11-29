package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository <Category, Long>{
    Category findByName(@Param("name") String name);
}
