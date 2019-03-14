package de.exxcellent.challenge.football;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface IFootballService {
    Collection<Football> getAll() throws IOException;
    Optional<Football> getMinDistance() throws IOException;
}
