package func;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Call {
    boolean isEqual;

    public Call(String url1, String url2) {
        String Response1 = makeRequest(url1);
        String Response2 = makeRequest(url2);
        isEqual = compareResponse(Response1, Response2, url1, url2);
    }

    public String makeRequest(String url) {
        Response response = null;
        try {
            RestAssured.baseURI = url;
            RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
            response = httpRequest.request(Method.GET,"");
        }
        catch(IllegalStateException e){
            return "Invalid uri";
        }
        return response.getBody().asString();
    }

    public boolean compareResponse(String response1, String response2, String url1, String url2) {
        if(response1.equals(response2)) {
            System.out.println( url1 + " Equals " + url2);
            Allure.addDescription(url1 + " Equals " + url2);
            return true;
        }
        else{
            System.out.println( url1 + " NOT Equals " + url2);
            Allure.addDescription(url1 + " Not Equals " + url2);
            return false;
        }
    }

    public boolean isEqual() {
        return isEqual;
    }
}
