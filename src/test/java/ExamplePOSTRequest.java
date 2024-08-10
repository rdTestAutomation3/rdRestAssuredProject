import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.GetUserResponse;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplePOSTRequest {

    public static void main(String[] args) {
        // 1. İstek yapılacak URL'yi belirleyin
        String url = "https://team1.thoughtspot.cloud/api/rest/2.0/users/search";

        // 2. İstek gövdesini ve başlığını oluşturun ve gerektiğinde parametreleri ekleyin

        Map<String, Object> header = new HashMap<>();
        header.put("Authorization","Bearer c2Vya2FuY3VyYXJkQGdtYWlsLmNvbTpKSE5vYVhKdk1TUlRTRUV0TWpVMkpEVXdNREF3TUNRd1MyazFSbkFyYzNwSmNqWXlVbmR1U1Zob2NtaDNQVDBrY2t4bk9GVlNlRE5uTW1kcFNYUTJZMVV2VHk5VE9ITnRNa2d2UTFGYVlUaEdTV1V3UW5nM1RubEVUVDA=");
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json");

        String requestBody = "{\n" +
                "  \"record_offset\": 0,\n" +
                "  \"record_size\": 10,\n" +
                "  \"include_favorite_metadata\": false\n" +
                "}";

        // 3. İstek başlıklarını belirleyin (opsiyonel)
        String contentType = ContentType.JSON.toString();

        // 4. POST isteğini gönderin
        Response response = RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .body(requestBody)
                .when().log().all()
                .post(url);

        // 5. Yanıtı işleyin ve doğrulamalar yapın
        response.then().log().all();


        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().jsonPath().getString("[0].id")).isEqualTo("2d0b8b66-a1ef-4c67-aff4-0f5812efa60b");
        assertThat(response.body().jsonPath().getString("[0].name")).isEqualTo("serkancurard@gmail.com");
        assertThat(response.jsonPath().getBoolean("[0].can_change_password")).isFalse();


    }
}

