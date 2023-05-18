package com.dota2.rozuke;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes = RozukeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ContainerConfig {
    @Container
    private static final MongoDBContainer MONGO_DB_CONTAINER = new MongoDBContainer("mongo:latest").withReuse(true);



    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", MONGO_DB_CONTAINER::getReplicaSetUrl);
        registry.add("spring.data.mongodb.username", () -> "rootuser");
        registry.add("spring.data.mongodb.password", () -> "rootpass");
        registry.add("spring.data.mongodb.database", () -> "dota2matches");

    }

    @BeforeAll
    public static void setup() {
        MONGO_DB_CONTAINER.start();
    }

    @AfterAll
    public static void tearDown() {
        MONGO_DB_CONTAINER.stop();
    }

}
