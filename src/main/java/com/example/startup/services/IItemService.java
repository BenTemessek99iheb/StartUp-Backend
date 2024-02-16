package com.example.startup.services;

import com.example.startup.dto.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface IItemService {

  //  public ItemDTO addItem(ItemDTO itemDTO);

    public ItemDTO getItemById(UUID id);

    public ItemDTO updateItem(UUID id, ItemDTO itemDTO);

    public void deleteItem(UUID id);

    public List<ItemDTO> getAllItems();

    public List<ItemDTO> getItemsByMenuId(UUID menuId);
    public ItemDTO addItemToMenu(UUID menuId, ItemDTO itemDTO) ;


    }
