package API;

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

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GetSingleUser() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users/2");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GetSingleUserNotFound() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/users/23");

        Assert.assertEquals(response.getStatusCode() /*actual value*/, 404 /*expected value*/,
                "404 - Correct status code returned");
    }

    @Test
    public void GetListUsers() {

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/api/unknown");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void CreateUserPOST(){
        RequestSpecification httpRequest = RestAssured.given();

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
        RequestSpecification httpRequest = RestAssured.given();

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
        RequestSpecification httpRequest = RestAssured.given();

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
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.delete("/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println("The status received: " + response.statusLine());

        Assert.assertEquals(response.statusCode() /*actual value*/, 204 /*expected value*/,
                "Correct status code returned");

    }
}
