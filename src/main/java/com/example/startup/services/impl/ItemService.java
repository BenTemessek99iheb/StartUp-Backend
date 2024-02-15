package com.example.startup.services.impl;

import com.example.startup.dto.ItemDTO;
import com.example.startup.entities.Item;
import com.example.startup.entities.Menu;
import com.example.startup.mapper.ItemMapper;
import com.example.startup.repositories.ItemRepo;
import com.example.startup.repositories.MenuRepo;
import com.example.startup.services.IItemService;
import com.example.startup.util.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class ItemService implements IItemService {
    public static MenuRepo menuRepository;
    public static ItemRepo itemRepository;
    public static ItemMapper itemMapper;

    public List<ItemDTO> getItemsByMenuId(UUID menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found"));

        // Assuming that you have a method in your repository to find items by menu
        // and you also have an ItemMapper to convert entities to DTOs
        List<Item> items = itemRepository.findItemsByMenuId(menuId);
        return items.stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = itemMapper.toModel(itemDTO);
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }

    public ItemDTO getItemById(UUID id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        return itemMapper.toDto(item);
    }

    public ItemDTO updateItem(UUID id, ItemDTO itemDTO) {
        Item itemToUpdate = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        // Update item properties here
        itemToUpdate.setName(itemDTO.getName());
        itemToUpdate.setDescription(itemDTO.getDescription());
        itemToUpdate.setPicture(itemDTO.getPicture());
        itemToUpdate.setPrice(itemDTO.getPrice());
        // More properties can be set as per your requirement

        Item updatedItem = itemRepository.save(itemToUpdate);
        return itemMapper.toDto(updatedItem);
    }

    public void deleteItem(UUID id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        itemRepository.delete(item);
    }

    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

}
