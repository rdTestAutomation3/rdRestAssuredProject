import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ExamplePOSTRequest {

    public static void main(String[] args) {
        // 1. İstek yapılacak URL'yi belirleyin
        String url = "https://petstore.swagger.io/v2/user";

        // 2. İstek gövdesini ve başlığını oluşturun ve gerektiğinde parametreleri ekleyin
        Map<String, Object> header = new HashMap<>();
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json");

        Faker faker = new Faker();
        String username = faker.name().username();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.bothify("????##@gmail.com");
        String password = faker.regexify("[a-z1-9]{6}");
        String phone = faker.phoneNumber().cellPhone();

        // Post Test
        String createUserRequest = "{\n  \"id\": 0," +
                "\n  \"username\":\"" + username + "\",\n " +
                "\"firstName\": \"" + firstname + "\",\n " +
                "\"lastName\": \"" + lastname + "\",\n " +
                "\"email\": \"" + email + "\",\n  " +
                "\"password\": \"" + password + "\",\n  " +
                "\"phone\": \"" + phone+"\",\n  " +
                "\"userStatus\": 1 \n}";

        // 3. POST isteğini gönderin
        Response response = RestAssured.given()
                .headers(header)
                .body(createUserRequest)
                .when().log().all()
                .post(url);

        // 4. Yanıtı işleyin ve doğrulamalar yapın
        response.then().log().all().statusCode(200)
                .body("code", equalTo(200))
                .body("message", not(equalTo("0")));

        String message = response.jsonPath().getString("message");

        assertThat(message).isNotEqualTo("0");

        // Get Test
        Response getResponse = RestAssured.given()
                .headers(header)
                .when().log().all()
                .get(url+"/"+username);

        getResponse.then().log().all()
                .statusCode(200)
                .body("id", equalTo(Long.valueOf(message)))
                .body("userStatus",equalTo(1));

        assertThat(getResponse.jsonPath().getLong("id")).isEqualTo(Long.valueOf(message));
        assertThat(getResponse.jsonPath().getString("firstName").strip()).isEqualTo(firstname);
        assertThat(getResponse.jsonPath().getString("username").strip()).isEqualTo(username);
        assertThat(getResponse.jsonPath().getString("lastName")).isEqualTo(lastname);
        assertThat(getResponse.jsonPath().getString("email")).isEqualTo(email);
        assertThat(getResponse.jsonPath().getString("password")).isEqualTo(password);
        assertThat(getResponse.jsonPath().getString("phone")).isEqualTo(phone);
    }
}

