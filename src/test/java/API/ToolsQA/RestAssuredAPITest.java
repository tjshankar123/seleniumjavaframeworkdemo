package API.ToolsQA;


import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredAPITest {
    @BeforeClass
    public void setup() {
//        RestAssured.baseURI = "https://api.github.com";
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RestAssured.port = 443;
    }

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GetWeatherDetailsCondensed() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request that is to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Call RequestSpecification.get() method to get the response. Make sure you specify the resource name.
        Response response;
        response = httpRequest.get("");

        // Response.asString method will directly return the content of the body as String.
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test
    public void IteratingHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test
    public void GetBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Access header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        // Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);

        // Access header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }

    @Test
    public void ValidateBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Access header with a given name. Header = Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);

        // Access header with a given name. Header = Server
        String serverType = response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);
    }

    @Test
    public void postRequestBooksAPI() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification request = RestAssured.given();

        // JSONObject is a class that represents a Simple JSON.
        // We can add Key - Value pairs using the put method

        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString()); // Post the request and check the response
        Response response = request.post("/BookStore/V1/Books");
        System.out.println("The status received: " + response.statusLine());
    }

    @Test
    public void updateBook() {
        RestAssured.baseURI = "https://demoqa.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
        String isbn = "9781449325865";
        String userId = "toolsqa_test";

        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        //Calling the Delete API with request body
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");

        //Fetching the response code from the request and validating the same
        System.out.println("The response code - " + res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(), 502);
    }

    @Test
    public void deleteBook() {
        String userId= "de5d75d1-59b4-487e-b632-f18bc0665c0d";
        String baseUrl="https://demoqa.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
        String isbn ="9781449337711";
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        //Calling the Delete API with request body
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");

        //Fetching the response code from the request and validating the same
        System.out.println("The response code is - " +res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),401);

    }
}


