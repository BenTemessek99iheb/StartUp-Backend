package com.example.startup.controllers;

import com.example.startup.dto.CategoryDTO;
import com.example.startup.dto.ItemDTO;
import com.example.startup.dto.MenuDTO;
import com.example.startup.services.ICategoryService;
import com.example.startup.services.impl.ItemService;
import com.example.startup.services.impl.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final ICategoryService categoryService;
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<MenuDTO> addMenu(@RequestBody MenuDTO menuDto) {
        MenuDTO createdMenu = menuService.addMenu(menuDto);
        return new ResponseEntity(createdMenu, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getMenuById(@RequestParam UUID menuId) {
        MenuDTO theMenu = menuService.getMenuById(menuId);
        return new ResponseEntity(theMenu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDTO> updateMenu(@RequestBody MenuDTO menuDTO, UUID id) {
        MenuDTO updatedMenu = menuService.updateMenu(id, menuDTO);
        return ResponseEntity.ok(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMenu(@PathVariable UUID id) {
        menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuDTO>> retrieveAllMenus() {
        List<MenuDTO> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/items-per-menu/{id}")
    public ResponseEntity<List<ItemDTO>> getListOfItems(@RequestParam UUID menuId) {
        List<ItemDTO> items = menuService.ListOfItems(menuId);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategory = categoryService.addCategory(categoryDTO);
        return new ResponseEntity(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable UUID id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Item endpoints

    @PostMapping("/{menuId}/items")
    public ResponseEntity<ItemDTO> addItemToMenu(@PathVariable UUID menuId, @RequestBody ItemDTO itemDTO) {
        ItemDTO createdItem = itemService.addItemToMenu(menuId, itemDTO);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }


    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable UUID id) {
        ItemDTO item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable UUID id, @RequestBody ItemDTO itemDTO) {
        ItemDTO updatedItem = itemService.updateItem(id, itemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    // Endpoint to add a category to a menu
    @PostMapping("/{menuId}/categories/{categoryId}")
    public ResponseEntity<MenuDTO> addCategoryToMenu(@PathVariable UUID menuId, @PathVariable UUID categoryId) {
        MenuDTO updatedMenu = menuService.addCategoryToMenu(menuId, categoryId);
        return ResponseEntity.ok(updatedMenu);
    }

    // Endpoint to remove a category from a menu
    @DeleteMapping("/{menuId}/categories/{categoryId}")
    public ResponseEntity<MenuDTO> removeCategoryFromMenu(@PathVariable UUID menuId, @PathVariable UUID categoryId) {
        MenuDTO updatedMenu = menuService.removeCategoryFromMenu(menuId, categoryId);
        return ResponseEntity.ok(updatedMenu);
    }

    @GetMapping("/{menuId}/items")
    public ResponseEntity<List<ItemDTO>> getItemsForMenu(@PathVariable UUID menuId) {
        List<ItemDTO> itemDTOs = itemService.getItemsByMenuId(menuId);
        return ResponseEntity.ok(itemDTOs);
    }


}
