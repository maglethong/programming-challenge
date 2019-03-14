package de.exxcellent.challenge.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private int day;
    private float minTemp;
    private float maxTemp;

    public float getTempSpread() {
        return maxTemp - minTemp;
    }
}
