package com.example.startup.util.tools;

public interface GenericMapper<E, D> {

    E toModel(D dto);

    D toDto(E entity);
}
