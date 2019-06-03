package com.example.base;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class GreetingService {
    public String greeting(String name) {
        return "hello " + name + "\n";
    }

    public CompletionStage<String> greetingAsc(String name) {
        return CompletableFuture.supplyAsync(() -> "hello " + name);
    }
}
