package com.example.base;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/asc/{name}")
    public CompletionStage<String> greetingAsc(@PathParam("name") String name) {
        return service.greetingAsc(name);
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/asc")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> helloasc() {
        return CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
    }
}