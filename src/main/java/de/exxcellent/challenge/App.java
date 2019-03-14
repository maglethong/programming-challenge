package de.exxcellent.challenge;

import de.exxcellent.challenge.football.Team;
import de.exxcellent.challenge.football.TeamCsvService;
import de.exxcellent.challenge.football.ITeamService;
import de.exxcellent.challenge.weather.IDayService;
import de.exxcellent.challenge.weather.Day;
import de.exxcellent.challenge.weather.DayCsvService;

import java.util.Optional;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        try {
            // TODO => Linux compatible?
            // TODO => Code replicated!!!
            String csvPath = App.class
                    .getResource("weather.csv")
                    .getPath()
                    .substring(1); // Remove starting '/'

            IDayService dayService = new DayCsvService(csvPath);

            Optional<Day> dayWithSmallestTempSpread = dayService.getLargestSpread();
            if (dayWithSmallestTempSpread.isPresent()) {
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread.get().getDay());
            } else {
                System.out.printf("Day not found!");
            }

            // TODO => Linux compatible?
            csvPath = App.class
                    .getResource("football.csv")
                    .getPath()
                    .substring(1); // Remove starting '/'

            ITeamService teamService = new TeamCsvService(csvPath);

            Optional<Team> teamWithSmallestGoalSpread = teamService.getMinDistance();
            if (teamWithSmallestGoalSpread.isPresent()) {
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread.get().getTeamName());
            } else {
                System.out.printf("Team not found!");
            }
        } catch (Exception ignored) {
            // TODO Treat exception
        }
    }
}
