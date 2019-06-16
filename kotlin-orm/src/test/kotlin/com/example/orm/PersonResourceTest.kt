package com.example.orm

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class PersonResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/person")
          .then()
             .statusCode(200)
             .body(`is`("hello"))
    }

}