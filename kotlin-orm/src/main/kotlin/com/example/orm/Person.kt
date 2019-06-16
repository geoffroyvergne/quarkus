package com.example.orm

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?=0,
    var name: String?="",
    var birth: LocalDate?= LocalDate.now(),
    var status: Status?=Status.Alive

): PanacheEntityBase() {
    fun findByName(name: String): Person {
        return find<PanacheEntityBase>("name", name).firstResult()
    }

    fun findAlive(): List<Person> {
        return list<Person>("status", Status.Alive)
    }

    fun deleteStefs() {
        delete("name", "Stef")
    }
}

enum class Status {
    Alive,
    Dead,
    Zombi
}