package br.com.mancini.pessoas;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.com.mancini.pessoas.entitties.Pessoa;
import br.com.mancini.pessoas.respositories.PessoaRepository;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import javax.inject.Inject;

@QuarkusTest
public class PessoasResourceTest {

    @Inject
    PessoaRepository pessoaRepository;

    @Test
    public void testGetPessoas() {
        pessoaRepository.deleteAll();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Bruno Mancini");
        pessoa.setCpf("333.333.333-33");
        pessoa.setIdade(34);
		pessoaRepository.save(pessoa);
        
        given()
        .when()
        .get("/pessoas")
        .then()
            .statusCode(200)
            .body(
                "size()", is(1), 
                "[0].nome", equalTo("Bruno Mancini"),
                "[0].cpf", equalTo("333.333.333-33"),
                "[0].idade", is(34)
            );
    }

    @Test
    public void testPostPessoas() {
        pessoaRepository.deleteAll();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Mancini");
        pessoa.setCpf("444.444.444-44");
        pessoa.setIdade(30);
        
        given()
        .when()
        .contentType(ContentType.JSON)
        .with().body(pessoa)
        .post("/pessoas")
        .then()
            .statusCode(201)
            .body(
                "nome", equalTo("Mancini"),
                "cpf", equalTo("444.444.444-44"),
                "idade", is(30)
            );
    }
}