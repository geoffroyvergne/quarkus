package com.example.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

@QuarkusTest
open class GreetingResourceTest {

    /*@Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/greeting")
          .then()
             .statusCode(200)
             .body(`is`("hello"))
    }*/

    @Test
    fun testHelloEndpoint() {
        given()
                .`when`().get("/greeting")
                .then()
                .statusCode(200)
                .body("message", equalTo("hello"))
    }

}