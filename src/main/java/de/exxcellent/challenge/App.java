package de.exxcellent.challenge;

import de.exxcellent.challenge.football.Football;
import de.exxcellent.challenge.football.FootballCsvService;
import de.exxcellent.challenge.football.IFootballService;
import de.exxcellent.challenge.weather.IWeatherService;
import de.exxcellent.challenge.weather.Weather;
import de.exxcellent.challenge.weather.WeatherCsvService;

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

            IWeatherService weatherService = new WeatherCsvService(csvPath);

            Optional<Weather> dayWithSmallestTempSpread = weatherService.getLargestSpread();
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

            IFootballService footballService = new FootballCsvService(csvPath);

            Optional<Football> teamWithSmallestGoalSpread = footballService.getMinDistance();
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
