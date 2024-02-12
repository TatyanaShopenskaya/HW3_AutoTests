package accuweather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
class ForecastHomeWorkTest {

    public class ForecastsTest extends AccuweatherAbstractTest {


        @Test
        void forecast1DayTest() {
            String code = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/1day/{locationKey}")
                    .then().statusCode(200).extract()
                    .jsonPath()
                    .getString("Code");

            String message = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/1day/{locationKey}")
                    .then().statusCode(200).extract()
                    .jsonPath()
                    .getString("Message");

            Assertions.assertAll(() -> Assertions.assertEquals("200", code),
                    () -> Assertions.assertEquals("200", message));

        }
        @Test

        void forecast10DaysTest() {
            String code = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/10day/{locationKey}")
                    .then().statusCode(401).extract()
                    .jsonPath()
                    .getString("Code");

            String message = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/10day/{locationKey}")
                    .then().statusCode(401).extract()
                    .jsonPath()
                    .getString("Message");


            Assertions.assertAll(() -> Assertions.assertEquals("Unauthorized", code),
                    () -> Assertions.assertEquals("Api Authorization failed", message));
        }
        @Test

        void forecast15DaysTest() {
            String code = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/15day/{locationKey}")
                    .then().statusCode(401).extract()
                    .jsonPath()
                    .getString("Code");

            String message = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when()
                    .get(getBaseUrl() + "/forecasts/v1/daily/15day/{locationKey}")
                    .then().statusCode(401).extract()
                    .jsonPath()
                    .getString("Message");

            Assertions.assertAll(() -> Assertions.assertEquals("Unauthorized", code),
                    () -> Assertions.assertEquals("Api Authorization failed", message));

        }

    }
}
