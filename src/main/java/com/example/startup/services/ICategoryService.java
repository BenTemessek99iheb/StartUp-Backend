package com.example.startup.services;

import com.example.startup.dto.CategoryDTO;
import com.example.startup.dto.EventDTO;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    public CategoryDTO addCategory(CategoryDTO categoryDTO);

    public CategoryDTO getCategoryById(UUID id);

    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO);

    public void deleteCategory(UUID id);

    public List<CategoryDTO> getAllCategories();

}
