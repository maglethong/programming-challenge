package de.exxcellent.challenge.weather;

import java.io.IOException;
import java.util.Collection;

public interface IWeatherService {
    Collection<Weather> getAll() throws IOException;
}
