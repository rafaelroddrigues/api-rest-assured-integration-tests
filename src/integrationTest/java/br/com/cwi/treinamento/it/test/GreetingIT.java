package br.com.cwi.treinamento.it.test;

import br.com.cwi.treinamento.it.baseTest.BaseTest;
import br.com.cwi.treinamento.it.category.FlightCheckTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.when;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GreetingIT extends BaseTest {

    @Test
    @Category(FlightCheckTests.class)
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Greetings")
    @Description("Saúda o usuário com uma mensagem padrão")
    @DisplayName("Saúda com mensagem padrão")
    public void deveSaudarUsuarioPadraoQuandoFeitoRequestCorreto() {
        when().
                get("/greeting").
                then().log().all().
                statusCode(200).
                body("content", is("Hello, World!"));
    }

    @Test
    @Category(FlightCheckTests.class)
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Greetings")
    @Description("Saúda o usuário com uma mensagem customizada")
    @DisplayName("Saúda com mensagem customizada")
    public void deveSaudarUsuarioInformadoQuandoFeitoRequestCorreto() {
        String nome = "Rafael";

        Response response = when().
                get("/greeting?name=" + nome);

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.time() < 3000);
        assertThat(response.getBody().asString(), containsString("Hello, " + nome + "!"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Greetings")
    @Description("Tenta saudar o usuário com uma mensagem padrão")
    @DisplayName("Tenta saudar com mensagem customizada")
    public void deveRetornarErroQuandoPathNaoExistir() {
        when().
                get("/greetings").
                then().log().all().
                statusCode(404);
    }

}
