package de.exxcellent.challenge.weather;

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

public class DayCsvService extends AbstractCsvService<Day> implements IDayService {

    private static final String CSV_RESOURCE = "/de/exxcellent/challenge/weather.csv";

    @Override
    public Collection<Day> getAll() throws IOException {
        return getAll(CSV_RESOURCE);
    }

    @Override
    public Optional<Day> getLargestSpread() throws IOException {
        return this.getAll()
                .stream()
                .reduce((a, b) -> a.getTempSpread() > b.getTempSpread() ? a : b);
    }

    @Override
    protected Day recordToEntity(CSVRecord csvRecord) {
        Day weather = new Day();

        weather.setDay(Integer.parseInt(csvRecord.get("Day")));
        weather.setMaxTemp(Float.parseFloat(csvRecord.get("MxT")));
        weather.setMinTemp(Float.parseFloat(csvRecord.get("MnT")));

        return weather;
    }
}