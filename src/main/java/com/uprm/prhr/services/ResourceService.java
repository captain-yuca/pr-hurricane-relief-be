package com.uprm.prhr.services;

import com.uprm.prhr.exceptions.CategoryNotFoundException;
import com.uprm.prhr.models.Category;
import com.uprm.prhr.models.Resource;
import com.uprm.prhr.repositories.CategoryRepository;
import com.uprm.prhr.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService{
    private CategoryRepository categoryRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(CategoryRepository categoryRepository, ResourceRepository resourceRepository) {
        this.categoryRepository = categoryRepository;
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(String name, String categoryName){
        Category category = this.categoryRepository.findByName(categoryName);
        if(category == null) {
            throw new CategoryNotFoundException(categoryName);
        }
        return resourceRepository.save(new Resource(name, category));
    }

    public Iterable<Resource> lookup(){
        return resourceRepository.findAll();
    }
    public long total() {
        return resourceRepository.count();
    }
}
