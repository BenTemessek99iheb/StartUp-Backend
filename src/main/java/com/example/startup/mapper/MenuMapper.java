package com.example.startup.mapper;

import com.example.startup.dto.MenuDTO;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface MenuMapper extends GenericMapper<MenuMapper, MenuDTO> {
}
