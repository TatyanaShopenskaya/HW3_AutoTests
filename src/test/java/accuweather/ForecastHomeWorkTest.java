package accuweather;
import org.max.seminar.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ForecastHomeWorkTest extends AccuweatherAbstractTest{
        @Test
        void forecast1DayTest() {
            Weather weather = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)
                    .when().get(getBaseUrl() + "/forecasts/v1/daily/1day/{locationKey}")
                    .then().statusCode(200).time(lessThan(2000L))
                    .extract().response().body().as(Weather.class);
            Assertions.assertEquals(1,weather.getDailyForecasts().size());
            System.out.println(weather);

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

