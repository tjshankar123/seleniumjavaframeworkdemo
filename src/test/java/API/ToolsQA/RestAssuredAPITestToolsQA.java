package API.ToolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RestAssuredAPITestToolsQA  {

    static String URL = "https://demoqa.com/swagger/#/BookStore";

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
    public void GetWeatherDetailsCondensed()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

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
}
