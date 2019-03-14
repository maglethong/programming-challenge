package de.exxcellent.challenge.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private int day;
    private float minTemp;
    private float maxTemp;

    public float getTempSpread() {
        return maxTemp - minTemp;
    }
}
