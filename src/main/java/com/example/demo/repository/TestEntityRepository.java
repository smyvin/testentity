package com.example.demo.repository;

import com.example.demo.entity.TestEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TestEntityRepository extends JpaRepository<TestEntity, UUID> {

    @Override
    @EntityGraph(attributePaths = { "document", "dictionaryValue" })
    List<TestEntity> findAll();

    @Override
    @EntityGraph(attributePaths = { "document", "dictionaryValue" })
    Optional<TestEntity> findById(UUID uuid);
}
