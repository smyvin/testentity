package com.example.demo.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "test_entity")
open class TestEntity (
        @Id open val id: UUID = UUID.randomUUID(),
){
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "document_id")
        open var document: Document? = null

        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "dictionary_value_id")
        open var dictionaryValue: DictionaryValue? = null

        @Column(name = "sort_order")
        open var sortOrder: Boolean = true

        @Column(name = "test_id")
        open var testId: UUID? = null

        @Column(name = "test_name")
        open var testName: String = "Test"
}