package com.example.orm;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class PersonRepository implements PanacheRepositoryBase<Person,Integer> {

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

}
