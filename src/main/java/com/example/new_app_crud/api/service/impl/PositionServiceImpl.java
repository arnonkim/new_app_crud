package com.example.new_app_crud.api.service.impl;

import com.example.new_app_crud.api.entities.Position;
import com.example.new_app_crud.api.repository.PositionRepository;
import com.example.new_app_crud.api.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepo;

    public List<Position> findAll() {
        return positionRepo.findAll();
    }

    @Override
    public Position findById(Long id) {
        return positionRepo.findById(id).get();
    }

    @Override
    public Position save(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public void deleteById(Long id) {
        positionRepo.deleteById(id);
    }
}
