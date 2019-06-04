package com.example.orm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Person> persons = personRepository.findAlive();

        LOG.info("employee list : " + persons.toString());

        return Response.ok(persons).build();
    }
}