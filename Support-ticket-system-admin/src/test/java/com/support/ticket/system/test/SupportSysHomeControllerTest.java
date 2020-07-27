package com.support.ticket.system.test;

import com.support.ticket.system.STSApplication;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =
        {STSApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupportSysHomeControllerTest {
    @LocalServerPort
    protected int randomPort;

    @Test
    public void step_01_POST_create_new_ticket() throws Exception {
        final ValidatableResponse response = putRequest("/" + "add",
                "/rest-assured/sts/createTicket.json");

        response.statusCode(HttpStatus.SC_OK);

    }

    public ValidatableResponse putRequest(String path, String pathJson) throws IOException {
        return RestAssured.given()
                .accept("application/json;charset=UTF-8")
                .contentType("application/json;charset=UTF-8")
                .header("x-username", "anthuwan")
                .body(getResource(pathJson))
                .when()
                .port(randomPort)
                .post(path)
                .then();
    }

    public String getResource(String name) throws IOException {
        try (final BufferedReader inputData = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream(name)))) {
            return inputData.lines().collect(Collectors.joining("\n"));
        }
    }
}
