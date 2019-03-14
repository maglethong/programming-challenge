package de.exxcellent.challenge.weather;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeatherCsvService implements IWeatherService {

    private final String csvPath;

    public WeatherCsvService(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public Collection<Weather> getAll() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
                .withDelimiter(',')
        );

        List<Weather> days = new ArrayList<>();
        for (CSVRecord csvRecord : csvParser) {
            days.add(recordToWeather(csvRecord));
        }
        return days;
    }

    private Weather recordToWeather(CSVRecord csvRecord) {
        Weather weather = new Weather();

        weather.setDay(Integer.parseInt(csvRecord.get("Day")));
        weather.setMaxTemp(Float.parseFloat(csvRecord.get("MxT")));
        weather.setMinTemp(Float.parseFloat(csvRecord.get("MnT")));

        return weather;
    }
}