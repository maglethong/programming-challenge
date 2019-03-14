package de.exxcellent.challenge.football;

import de.exxcellent.challenge.csv.AbstractCsvService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TeamCsvService extends AbstractCsvService<Team> implements ITeamService {

    private static final String CSV_RESOURCE = "/de/exxcellent/challenge/football.csv";

    @Override
    public Collection<Team> getAll() throws IOException {
        return getAll(CSV_RESOURCE);
    }


    @Override
    public Optional<Team> getMinDistance() throws IOException {
        return this.getAll()
                .stream()
                .reduce((a, b) -> a.getGoalDistance() < b.getGoalDistance() ? a : b);
    }

    @Override
    protected Team recordToEntity(CSVRecord csvRecord) {
        Team weather = new Team();

        weather.setTeamName(csvRecord.get("Team"));
        weather.setGoalsAllowed(Integer.parseInt(csvRecord.get("Goals Allowed")));
        weather.setGoals(Integer.parseInt(csvRecord.get("Goals")));

        return weather;
    }
}
