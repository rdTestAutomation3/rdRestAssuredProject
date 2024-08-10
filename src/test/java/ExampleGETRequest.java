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
        String url = "https://team1.thoughtspot.cloud/api/rest/2.0/auth/session/token";


        // 2. İstek başlıklarını belirleyin (opsiyonel)
        String contentType = ContentType.JSON.toString();

        Map<String, Object> header = new HashMap<>();
        header.put("Accept", "application/json");
        header.put("Authorization","Bearer c2Vya2FuY3VyYXJkQGdtYWlsLmNvbTpKSE5vYVhKdk1TUlRTRUV0TWpVMkpEVXdNREF3TUNRd1MyazFSbkFyYzNwSmNqWXlVbmR1U1Zob2NtaDNQVDBrY2t4bk9GVlNlRE5uTW1kcFNYUTJZMVV2VHk5VE9ITnRNa2d2UTFGYVlUaEdTV1V3UW5nM1RubEVUVDA=");


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
                .body("valid_for_user_id", equalTo("2d0b8b66-a1ef-4c67-aff4-0f5812efa60b"))
                .body("valid_for_username", equalTo("serkancurard@gmail.com"));
    }
}

