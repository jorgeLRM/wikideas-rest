package com.ideasfactory.service;

import com.ideasfactory.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category save(Category category);

}
