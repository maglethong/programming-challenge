package de.exxcellent.challenge.weather;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface IWeatherService {
    Collection<Weather> getAll() throws IOException;
    Optional<Weather> getLargestSpread() throws IOException;
}
