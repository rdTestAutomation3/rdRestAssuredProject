import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.IsEqual.equalTo;


public class ExampleGETRequest {

    public static void main(String[] args) {
        // 1. İstek yapılacak URL'yi belirleyin
        String url = "https://try-everywhere.thoughtspot.cloud/api/rest/2.0/auth/session/token";


        // 2. İstek başlıklarını belirleyin (opsiyonel)
        String contentType = ContentType.JSON.toString();

        Map<String, Object> header = new HashMap<>();
        header.put("Accept", "application/json");
        header.put("Authorization","Bearer ZGVtb19kZXZ1c2VyOkpITm9hWEp2TVNSVFNFRXRNalUySkRVd01EQXdNQ1JUWkZZNGVqQjFRbkY0ZDIxR2FWQkxkRlp6ZURsM1BUMGtPRkJSUWtVM2RFbHFMMDFsVEdoVFJYSTVhaXQwWVhac1JreDZNWEZhV1VOdU1XSmtNVXMyUldvMlZUMA==");


        // 3. GET isteğini gönderin
        Response response = RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .when().log().headers()
                .get(url);


        // 5. Yanıtı işleyin ve doğrulamalar yapın
        response.then().log().all()
                .statusCode(200)
                .body("$", hasKey("token"))
                .body("$", hasKey("creation_time_in_millis"))
                .body("$", hasKey("expiration_time_in_millis"))
                .body("valid_for_user_id", equalTo("61b37746-a9bc-4433-b0cb-7a0e03225932"))
                .body("valid_for_username", equalTo("demo_devuser"));
    }
}

