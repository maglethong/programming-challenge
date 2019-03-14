package de.exxcellent.challenge.csv;

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

public abstract class AbstractCsvService<T> {
    protected Collection<T> getAll(String csvResource) throws IOException {
        String csvPath = this.getClass()
                .getResource(csvResource)
                .getPath()
                .substring(1);

        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
                .withDelimiter(',')
        );

        List<T> items = new ArrayList<>();
        for (CSVRecord csvRecord : csvParser) {
            items.add(recordToEntity(csvRecord));
        }

        return items;
    }

    protected abstract T recordToEntity(CSVRecord csvRecord);
}
