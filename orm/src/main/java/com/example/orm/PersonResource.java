package com.example.orm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/person")
@Transactional
public class PersonResource {

    private static final Logger LOG = Logger.getLogger(PersonResource.class.getName());

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Person> persons = personRepository.findAlive();

        LOG.info("person list : " + persons.toString());

        return Response.ok(persons).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {

        Person person = personRepository.findPersonById(id);

        if(person == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        LOG.info("person : " + person.toString());

        return Response.ok(person).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Person person) {

        person.id = null;

        personRepository.persist(person);

        LOG.info("employee add : " + person.toString());

        return Response
                .status(Response.Status.CREATED)
                .entity(person)
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Person person) {

        person.delete("id", person.id);

        LOG.info("employee delete : " + person.toString());

        return Response
                .status(Response.Status.CREATED)
                .entity(person)
                .build();
    }
}