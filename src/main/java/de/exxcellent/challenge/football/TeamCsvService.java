package de.exxcellent.challenge.football;

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

public class TeamCsvService implements ITeamService {

    private static final String CSV_RESOURCE = "/de/exxcellent/challenge/football.csv";

    @Override
    // TODO => Duplicated code, maybe parent class for csv? -> worse readability + overhead
    public Collection<Team> getAll() throws IOException {
        String csvPath = this.getClass()
                .getResource(CSV_RESOURCE)
                .getPath()
                .substring(1);

        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
                .withDelimiter(',')
        );

        List<Team> days = new ArrayList<>();
        for (CSVRecord csvRecord : csvParser) {
            days.add(recordToFootball(csvRecord));
        }
        return days;
    }


    @Override
    public Optional<Team> getMinDistance() throws IOException {
        return this.getAll()
                .stream()
                .reduce((a, b) -> a.getGoalDistance() < b.getGoalDistance() ? a : b);
    }

    private Team recordToFootball(CSVRecord csvRecord) {
        Team weather = new Team();

        weather.setTeamName(csvRecord.get("Team"));
        weather.setGoalsAllowed(Integer.parseInt(csvRecord.get("Goals Allowed")));
        weather.setGoals(Integer.parseInt(csvRecord.get("Goals")));

        return weather;
    }
}
