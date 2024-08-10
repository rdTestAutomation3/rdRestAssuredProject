import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.awaitility.Awaitility;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class ExampleGetWithAwaitility {
    public static void main(String[] args) {
        Awaitility.reset();
        Awaitility.setDefaultPollDelay(100, MILLISECONDS);
        Awaitility.setDefaultPollInterval(2, SECONDS);
        Awaitility.setDefaultTimeout(7, SECONDS);

        String url = "https://demoqa.com/BookStore/v1/Books";


        // 2. İstek başlıklarını belirleyin (opsiyonel)
        String contentType = ContentType.JSON.toString();

        Map<String, Object> header = new HashMap<>();
        header.put("Accept", "application/json");


      /*  await().untilAsserted(() -> assertThat(
                RestAssured.given()
                        .contentType(contentType)
                        .headers(header)
                        .when().log().headers()
                        .get(url)
                        .then().log().all()
                        .statusCode(200)
                        .extract().path("books[0].isbn").toString()).isEqualTo("9781449325861"));

*/
        System.out.println("-------------------------");

        await().atMost(10, SECONDS).untilAsserted(() -> get(url).then().log().all().statusCode(200));

    }
}
