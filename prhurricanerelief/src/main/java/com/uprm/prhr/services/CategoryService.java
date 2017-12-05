package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.CategoryNotFoundException;
import com.uprm.prhr.models.Category;
import com.uprm.prhr.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name, String parentCategoryName){
            Category parentCategory = null;
            if(parentCategoryName != null){
                parentCategory = categoryRepository.findByName(parentCategoryName);
                if(parentCategory == null)
                    throw new CategoryNotFoundException(parentCategoryName);
            }
            return categoryRepository.save(new Category(name, parentCategory));
    }

    public long total(){
        return categoryRepository.count();
    }
}
