package br.com.cwi.treinamento.it.test;

import br.com.cwi.treinamento.it.baseTest.BaseTest;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GreetingIT extends BaseTest {

    @Test
    public void deveRetornarTodosUsuariosComSucesso() {
        Response response = given().
                header("Accept","application/json").
                when().
                    get(baseUrl + "/api/Users");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getBody().jsonPath().getList("ID").get(0).toString(), "1");
    }

    @Test
    public void deveRetornarDadosDoPrimeiroUsuarioComSucesso() {
        Response response = given().
                header("Accept","application/json").
                when().
                get(baseUrl + "/api/Users");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getBody().jsonPath().getList("ID").get(0).toString(), "1");
    }

    @Test
    public void deveRetornarUsuarioEspecificoComSucesso() {
        given().
                header("Accept","application/json")
                .param("id","1").
        when().
                get(baseUrl + "/api/Users/").
        then().
                log().all().
                statusCode(200);
    }

    @Test
    public void deveInserirNovoUsuarioComSucesso() throws JSONException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("ID", "201");
        requestParams.put("UserName", "john");
        requestParams.put("Password", "abc123");

        given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                body(requestParams.toString()).
        when().
                post(baseUrl + "/api/Users").
        then().
                log().all().
                statusCode(200);
    }

    @Test
    public void deveAtualizarUsuarioComSucesso() throws JSONException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("ID", "201");
        requestParams.put("UserName", "john");
        requestParams.put("Password", "abc123");

        given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                param("id","1").
        when().
                put(baseUrl + "/api/Users/").
        then().
                log().all().
                statusCode(200);
    }

    @Test
    public void deveRemoverUsuarioComSucesso() {
        given().
                header("Accept","application/json")
                .param("id","1").
        when().
                delete(baseUrl + "/api/Users/").
        then().
                statusCode(200);
    }

    @Test
    public void deveTentarRemoverUsuarioComIdAlfanumerico() {
        given().
                header("Accept","application/json")
                .param("id","1a").
                when().
                delete(baseUrl + "/api/Users/").
                then().
                statusCode(400);
    }

}
