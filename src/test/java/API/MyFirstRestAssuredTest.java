package API;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class MyFirstRestAssuredTest {
    final static String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    public static void main(String args[]){
    //    getResponseBody();
        getSpecificPartOfResponseBody();
    }

    //This will fetch the response body as is and log it. given and when are optional here
    public static void getResponseBody(){
        given().when().get(url).then().log().all();

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
    }

    public static void getSpecificPartOfResponseBody(){

        ArrayList<String> amounts = when().get(url).then().extract().path("result.statements.AMOUNT") ;
        int sumOfAll=0;
        for(String a:amounts){

            System.out.println("The amount value fetched is "+a);
            sumOfAll=sumOfAll+Integer.valueOf(a);
        }
        System.out.println("The total amount is "+sumOfAll);

    }
}
