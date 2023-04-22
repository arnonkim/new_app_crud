package com.example.new_app_crud.api.service;


import com.example.new_app_crud.api.entities.Position;

import java.util.List;

public interface PositionService {

    List<Position> findAll();

    Position findById(Long id);

    Position save(Position position);

    void deleteById(Long id);
}
