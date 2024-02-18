package com.example.startup.services;

import com.example.startup.dto.ItemDTO;
import com.example.startup.dto.MenuDTO;

import java.util.List;
import java.util.UUID;

public interface IMenuService {
    public MenuDTO addMenu(MenuDTO menuDTO);

    public MenuDTO getMenuById(UUID id);

    public MenuDTO updateMenu(UUID id, MenuDTO menuDTO);

    public void deleteMenu(UUID id);

    public List<MenuDTO> getAllMenus();

    public MenuDTO addCategoryToMenu(UUID menuId, UUID categoryId);

    public MenuDTO removeCategoryFromMenu(UUID menuId, UUID categoryId);
    //  public List<ItemDTO> ListOfItems(UUID menuId) ;
}
