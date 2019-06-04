package com.example.orm;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person,Integer> {
    // put your custom logic here as instance methods

    public Person findByName(String name){
        return find("name", name).firstResult();
    }

    public Person findPersonById(Integer id){
        return find("id", id).firstResult();
    }

    public List<Person> findAlive(){
        return list("status", Status.Alive);
    }

    public void deleteStefs(){
        delete("name", "Stef");
    }

    public List<Person> findAllPerson() { return listAll(); }

    public void deleteById(Integer id) { delete("id", id); }
}
