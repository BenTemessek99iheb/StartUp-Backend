package com.example.startup.mapper;

import com.example.startup.dto.ItemDTO;
import com.example.startup.entities.Item;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ItemMapper extends GenericMapper<Item, ItemDTO> {
}
