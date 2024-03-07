import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.GetUsersResponse;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplePOSTRequest {

    public static void main(String[] args) {
        // 1. İstek yapılacak URL'yi belirleyin
        String url = "https://try-everywhere.thoughtspot.cloud/api/rest/2.0/users/search";

        // 2. İstek gövdesini ve başlığını oluşturun ve gerektiğinde parametreleri ekleyin

        Map<String, Object> header = new HashMap<>();
        header.put("Authorization","Bearer ZGVtb19kZXZ1c2VyOkpITm9hWEp2TVNSVFNFRXRNalUySkRVd01EQXdNQ1JWZUhkUVkyZFpaaXN2YldSRldsSXZOVzlGYTA5QlBUMGtjV2hNYmtSdU5XbDRla3MxUVdWc1EyWnFZM1J2YVc1cmRGSmtVbEJQVDBaTVRtNVFWVEV4ZG13MlFUMA==");
        header.put("Accept","application/json");

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

        GetUsersResponse getUsersResponse = response.body().as(GetUsersResponse.class);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().jsonPath().getString("[0].id")).isEqualTo("2e1f6121-1315-4a0e-878c-0af6a7755482");

        System.out.println(getUsersResponse.id);

    }
}

