package de.exxcellent.challenge.football;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Football {
    private String teamName;
    private int goals;
    private int goalsAllowed;

    public int getGoalDistance() {
        return Math.abs(goalsAllowed - goals);
    }
}
