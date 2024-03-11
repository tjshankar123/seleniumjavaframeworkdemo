package API;

import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegressAPI {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.port = 443;
    }

    @AfterClass
    public void tearDown(){
        RestAssured.delete();
    }

    @Test
    public void GetUsersList() {
        //*** 'Given' is a pre-condition to getting everything ready before you start. ***

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GETUserList1() {
        // Set the base URI, using JSONPlaceholder as an example
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and save the response
        Response response = given()
                .when()
                .get("/api/users/1")
                .then()
                .extract()
                .response();

        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 200.
        System.out.println("Response JSON: " + response.getStatusCode());
      //  System.out.println((new GsonBuilder().setPrettyPrinting().create()).toJson(response));
    }

    @Test
    public void GetSingleUser() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users/2");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void GetSingleUserNotFound() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users/23");

        Assert.assertEquals(response.getStatusCode() /*actual value*/, 404 /*expected value*/,
                "404 - Correct status code returned");
    }

    @Test
    public void GetListUsers() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/unknown");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void POSTCreateUser(){
        RequestSpecification httpRequest = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","morpheus");
        requestParams.put("job","leader");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.post("/api/users");
        ResponseBody body = response.getBody();
        System.out.println("The status received: " + response.statusLine());
        System.out.println(body.toString());

        Assert.assertEquals(response.statusCode() /*actual value*/, 201 /*expected value*/,
                "Correct status code returned");

    }

    @Test
    public void UpdateUserPUT(){
        RequestSpecification httpRequest = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","morpheus");
        requestParams.put("job","zion resident");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.put("/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println("The status received: " + response.statusLine());

        Assert.assertEquals(response.statusCode() /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");

    }

    @Test
    public void UpdateUserPATCH(){
        RequestSpecification httpRequest = given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","morpheus");
        requestParams.put("job","zion resident");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.patch("/api/users/2");
        ResponseBody body = response.getBody();

        System.out.println("The status received: " + response.statusLine());
        System.out.println("body: " + body.prettyPrint());

        Assert.assertEquals(response.statusCode() /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");

    }

    @Test
    public void DeleteUserDELETE(){
        RequestSpecification httpRequest = given();

        Response response = httpRequest.delete("/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println("The status received: " + response.statusLine());

        Assert.assertEquals(response.statusCode() /*actual value*/, 204 /*expected value*/,
                "Correct status code returned");

    }

    @Test
    public void testGetRequest() {
        // Set the base URI, using JSONPlaceholder as an example
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and save the response
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // Print the JSON content of the response
        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 200.

        // Validate that the status code is 200
        response.then().statusCode(200); // validate that the response has a status code of 200.

        // Validate a specific field value in the response
        response.then().body("userId", equalTo(1));
        response.then().body("id", equalTo(1));
        response.then().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        response.then().body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }
}
