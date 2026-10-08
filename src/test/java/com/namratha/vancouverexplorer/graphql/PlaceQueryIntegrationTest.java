package com.namratha.vancouverexplorer.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.graphql.test.autoconfigure.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class PlaceQueryIntegrationTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void PlaceQueryIntegrationTest() {
        graphQlTester
                .document("""
                    query {
                        places(maxCost: 15) {
                            name
                        }
                    }
                    """)
                .execute()
                .path("places[*].name")
                .entityList(String.class)
                .hasSize(1)
                .contains("Stanley Park");
    }

}
