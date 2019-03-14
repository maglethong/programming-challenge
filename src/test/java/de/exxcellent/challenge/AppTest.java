package de.exxcellent.challenge;

import de.exxcellent.challenge.weather.IWeatherService;
import de.exxcellent.challenge.weather.Weather;
import de.exxcellent.challenge.weather.WeatherCsvService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    public void setUp() {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    public void weatherServiceGetAllTest() throws IOException {
        // TODO => Linux compatible?
        String csvPath = this.getClass()
                .getResource("weather.csv")
                .getPath()
                .substring(1); // Remove starting '/'

        IWeatherService service = new WeatherCsvService(csvPath);
        Collection<Weather> days = service.getAll();
        assertTrue(days.size() > 0, "Didn't read file correctly");
    }

    @Test
    public void runFootball() {
        App.main("--football", "football.csv");
    }

}