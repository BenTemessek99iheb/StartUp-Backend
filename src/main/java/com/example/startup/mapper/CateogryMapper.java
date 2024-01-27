package com.example.startup.mapper;

import com.example.startup.dto.CategoryDTO;
import com.example.startup.entities.Category;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CateogryMapper extends GenericMapper<Category, CategoryDTO> {
}
