package API;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredAPITest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RestAssured.port = 443;
    }

    @AfterClass
    public void tearDown(){
        RestAssured.delete();
    }

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any. In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GetWeatherDetailsCondensed()
    {
        // Specify the base URL to the RESTful web service
 //       RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Call RequestSpecification.get() method to get the response.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test
    public void GetBookDetails()
    {
        // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");

    }

    @Test
    public void GetPetDetails()
    {
        // Specify the base URL to the RESTful web service
  //      RestAssured.baseURI = "https://demoqa.com/Account/v1/User/";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("test");
 //       Response response = httpRequest.get();

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");
    }

    @Test
    public void IteratingHeaders()
    {
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test
    public void GetBookHeaders() {
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
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
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
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
    public void WeatherMessageBody1()
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());
    }

    @Test
    public void WeatherMessageBody2()
    {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/swagger.json";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/pet/0");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();

        // convert the body into lower case and then do a comparison to ignore casing.
        Assert.assertEquals(bodyAsString.toLowerCase().contains("doggie") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
    }

    @Test
    public void VerifyCityInJsonResponse()
    {
 //      RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given();
 //       Response response = httpRequest.get("/Hyderabad");
        Response response = httpRequest.get("/api/user?");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String city = jsonPathEvaluator.get("City");

        // Let us print the city variable to see what we got
        System.out.println("City received from Response " + city);

        // Validate the response
        Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");

    }



}