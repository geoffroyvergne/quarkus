package com.example.orm

import java.util.logging.Logger
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/person")
@Transactional
class PersonResource {

    private val LOG = Logger.getLogger(PersonResource::class.java.name)

    @Inject
    private lateinit var personRepository: PersonRepository

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list(): Response {

        val persons = personRepository.findAlive()

        LOG.info("person list : $persons")

        return Response.ok(persons).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id: Int): Response {

        val person = personRepository.findPersonById(id) ?: return Response
                .status(Response.Status.NOT_FOUND)
                .build()

        LOG.info("person : $person")

        return Response.ok(person).build()
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun add(person: Person): Response {

        person.id = null

        personRepository.persist(person)
        //person.persist()

        LOG.info("employee add : $person")

        return Response
                .status(Response.Status.CREATED)
                .entity(person)
                .build()
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun delete(person: Person): Response {

        //person.id = null

        //person.delete()
        //personRepository.delete(person)
        personRepository.deleteById(person.id)

        LOG.info("employee delete : $person")

        return Response
                .status(Response.Status.CREATED)
                .entity(person)
                .build()
    }
}