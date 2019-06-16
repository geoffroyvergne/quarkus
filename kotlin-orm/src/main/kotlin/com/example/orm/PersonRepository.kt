package com.example.orm

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
open class PersonRepository(): PanacheRepositoryBase<Person, Int> {
    open fun findByName(name: String): Person {
        return find("name", name).firstResult()
    }

    open fun findPersonById(id: Int?): Person? {
        return find("id", id).firstResult()
    }

    open fun findAlive(): List<Person>? {
        return list("status", Status.Alive)
    }

    open fun deleteStefs() {
        delete("name", "Stef")
    }

    open fun deleteById(id: Int?) {
        delete("id", id)
    }

    open fun findAllPerson(): List<Person>? {
        return listAll()
    }
}