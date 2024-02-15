package com.example.startup.services.impl;

import com.example.startup.dto.CategoryDTO;
import com.example.startup.entities.Category;
import com.example.startup.mapper.CateogryMapper;
import com.example.startup.repositories.CategoryRepo;
import com.example.startup.services.ICategoryService;
import com.example.startup.util.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CateogryService implements ICategoryService {

    private final CategoryRepo categoryRepository;

    private final CateogryMapper categoryMapper;

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toModel(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    public CategoryDTO getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return categoryMapper.toDto(category);
    }

    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryToUpdate.setName(categoryDTO.getName());
        categoryToUpdate.setDescription(categoryDTO.getDescription());
        categoryToUpdate.setPicture(categoryDTO.getPicture());
        // Make sure to convert the DTO's type to Etype if necessary
        categoryToUpdate.setType(categoryDTO.getType());

        Category updatedCategory = categoryRepository.save(categoryToUpdate);
        return categoryMapper.toDto(updatedCategory);
    }


    public void deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
