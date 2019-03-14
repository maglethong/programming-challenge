package de.exxcellent.challenge.football;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface ITeamService {
    Collection<Team> getAll() throws IOException;
    Optional<Team> getMinDistance() throws IOException;
}
