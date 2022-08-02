package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "dictionary_value")
public class DictionaryValue {

    @Id
    private UUID id = UUID.randomUUID();

    @Column
    private String name;
}
