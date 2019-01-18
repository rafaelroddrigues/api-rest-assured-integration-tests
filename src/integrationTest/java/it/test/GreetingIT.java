package it.test;

import it.baseTest.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class GreetingIT extends BaseTest {

    @Test
    public void deveSaudarUsuarioPadraoQuandoFeitoRequestCorreto() {
        when().
                get("/greeting").
                then().
                statusCode(200).
                body("content", is("Hello, World!"));
    }

    @Test
    public void deveSaudarUsuarioInformadoQuandoFeitoRequestCorreto() {
            String nome = "Rafael";

            when().
                    get("/greeting?name=" + nome).
                    then().
                    statusCode(200).
                    body("content", is("Hello, " + nome + "!"));
    }

    @Test
    public void deveRetornarErroQuandoPathNaoExistir() {
        when().
                get("/greetings").
                then().
                statusCode(404);
    }

}
