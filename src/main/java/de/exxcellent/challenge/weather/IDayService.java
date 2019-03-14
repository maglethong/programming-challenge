package de.exxcellent.challenge.weather;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface IDayService {
    Collection<Day> getAll() throws IOException;
    Optional<Day> getLargestSpread() throws IOException;
}
