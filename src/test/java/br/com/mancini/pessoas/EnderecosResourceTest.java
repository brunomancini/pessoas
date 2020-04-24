package br.com.mancini.pessoas;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class EnderecosResourceTest {

    // @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/enderecos/09932-240")
          .then()
             .statusCode(200)
             .body(
                 "bairro", equalTo("Jd. Paineiras"),
                 "cep", equalTo("09932-240"),
                 "uf", equalTo("SP")
             );
    }

}