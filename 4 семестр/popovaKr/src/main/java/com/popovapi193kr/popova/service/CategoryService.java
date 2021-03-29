package com.popovapi193kr.popova.service;

import com.popovapi193kr.popova.entity.Category;
import com.popovapi193kr.popova.entity.Task;
import com.popovapi193kr.popova.repository.CategoryRepository;
import com.popovapi193kr.popova.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category category, Category categoryFromDB) {
        BeanUtils.copyProperties(category, categoryFromDB, "id");
        return categoryRepository.save(categoryFromDB);
    }

    public boolean delete(Category category) {
        if (category != null){
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }
}
