package com.example.new_app_crud.api.controller;

import com.example.new_app_crud.api.entities.Position;
import com.example.new_app_crud.api.service.PositionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Operation(
            summary = "Get Position",
            description = "API : get Position"
    )
    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Position> positions = positionService.findAll();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Position position) {
        Position positionSaved = positionService.save(position);
        return new ResponseEntity<>(positionSaved, HttpStatus.OK);
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<Object> getById(@PathVariable Long positionId) {
        Position position = positionService.findById(positionId);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PutMapping("/{positionId}")
    public ResponseEntity<Object> update(@PathVariable Long positionId, @RequestBody Position position) {
        position.setId(positionId);
        Position positionSaved = positionService.save(position);
        return new ResponseEntity<>(positionSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<Object> delete(@PathVariable Long positionId) {
        positionService.deleteById(positionId);
        return new ResponseEntity<>("Position is deleted", HttpStatus.OK);
    }
}
