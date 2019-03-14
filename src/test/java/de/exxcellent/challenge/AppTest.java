package de.exxcellent.challenge;

import de.exxcellent.challenge.football.Team;
import de.exxcellent.challenge.football.TeamCsvService;
import de.exxcellent.challenge.football.ITeamService;
import de.exxcellent.challenge.weather.IDayService;
import de.exxcellent.challenge.weather.Day;
import de.exxcellent.challenge.weather.DayCsvService;
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
    public void dayServiceGetAllTest() throws IOException {
        // TODO => Linux compatible?
        String csvPath = this.getClass()
                .getResource("weather.csv")
                .getPath()
                .substring(1); // Remove starting '/'

        IDayService service = new DayCsvService(csvPath);
        Collection<Day> days = service.getAll();
        assertTrue(days.size() > 0, "Didn't read file correctly");
    }

    @Test
    public void teamServiceGetAllTest() throws IOException {
        // TODO => Linux compatible?
        String csvPath = this.getClass()
                .getResource("football.csv")
                .getPath()
                .substring(1); // Remove starting '/'

        ITeamService service = new TeamCsvService(csvPath);
        Collection<Team> teams = service.getAll();
        assertTrue(teams.size() > 0, "Didn't read file correctly");
    }

    @Test
    public void runFootball() {
        App.main("--football", "football.csv");
    }

}