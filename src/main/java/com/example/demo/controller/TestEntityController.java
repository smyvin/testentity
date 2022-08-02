package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestEntityRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/testentity")
public class TestEntityController {

    private final ModelMapper modelMapper;
    private final TestEntityRepository testEntityRepository;

    @GetMapping
    public ResponseEntity<List<TestEntity>> getAll(){
        return ResponseEntity.ok().body(testEntityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestEntity> getById(@PathVariable("id") UUID id){
        return testEntityRepository.findById(id)
                .map(entity -> ResponseEntity.ok().body(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "testentity не найден"));
    }

    @PostMapping
    public ResponseEntity<TestEntity> add(@RequestBody TestEntity testEntity) {
        TestEntity saved = testEntityRepository.save(testEntity);
        return ResponseEntity.ok().body(saved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TestEntity> updatePartially(@PathVariable("id") UUID id, @RequestBody TestEntity testEntityPatch) {
        TestEntity testEntity = testEntityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "testentity не найден"));

        modelMapper.map(testEntityPatch, testEntity);

        TestEntity saved = testEntityRepository.save(testEntity);
        return ResponseEntity.ok().body(saved);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id){
        testEntityRepository.deleteById(id);
    }


}
