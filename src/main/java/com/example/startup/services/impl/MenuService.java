package com.example.startup.services.impl;

import com.example.startup.dto.MenuDTO;
import com.example.startup.entities.Category;
import com.example.startup.entities.Menu;
import com.example.startup.mapper.MenuMapper;
import com.example.startup.repositories.CategoryRepo;
import com.example.startup.repositories.MenuRepo;
import com.example.startup.services.IMenuService;
import com.example.startup.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService implements IMenuService {

    private final MenuRepo menuRepository;

    private final CategoryRepo categoryRepository;

    private final MenuMapper menuMapper;

    public MenuDTO addMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.toModel(menuDTO);
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.toDto(savedMenu);
    }

    public MenuDTO getMenuById(UUID id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));
        return menuMapper.toDto(menu);
    }

    public MenuDTO updateMenu(UUID id, MenuDTO menuDTO) {
        Menu existingMenu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));
        Menu menu = menuMapper.toModel(menuDTO);
        menu.setId(existingMenu.getId());
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toDto(updatedMenu);
    }

    public void deleteMenu(UUID id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));
        menuRepository.delete(menu);
    }

    public List<MenuDTO> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream().map(menuMapper::toDto).collect(Collectors.toList());
    }

    public MenuDTO addCategoryToMenu(UUID menuId, UUID categoryId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        menu.getCategories().add(category);
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toDto(updatedMenu);
    }

    public MenuDTO removeCategoryFromMenu(UUID menuId, UUID categoryId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("Menu not found"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        menu.getCategories().remove(category);
        Menu updatedMenu = menuRepository.save(menu);
        return menuMapper.toDto(updatedMenu);
    }

}