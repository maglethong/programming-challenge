package de.exxcellent.challenge.weather;

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

public class DayCsvService implements IDayService {

    private static final String CSV_RESOURCE = "/de/exxcellent/challenge/weather.csv";

    @Override
    public Collection<Day> getAll() throws IOException {
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

        List<Day> days = new ArrayList<>();
        for (CSVRecord csvRecord : csvParser) {
            days.add(recordToWeather(csvRecord));
        }
        return days;
    }

    @Override
    public Optional<Day> getLargestSpread() throws IOException {
        return this.getAll()
                .stream()
                .reduce((a, b) -> a.getTempSpread() > b.getTempSpread() ? a : b);
    }


    private Day recordToWeather(CSVRecord csvRecord) {
        Day weather = new Day();

        weather.setDay(Integer.parseInt(csvRecord.get("Day")));
        weather.setMaxTemp(Float.parseFloat(csvRecord.get("MxT")));
        weather.setMinTemp(Float.parseFloat(csvRecord.get("MnT")));

        return weather;
    }
}