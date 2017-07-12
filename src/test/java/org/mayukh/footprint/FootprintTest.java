package org.mayukh.footprint;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mayukh.footprint.model.auto.Battery;
import org.mayukh.footprint.model.auto.Car;
import org.mayukh.footprint.model.auto.Engine;
import org.mayukh.footprint.model.auto.GpsUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Created by mayukh42 on 7/12/2017.
 *
 * Integration tests
 */
public class FootprintTest {

    private final String location = "target/";
    private final String jsonFile = "footprint.json";

    @Test
    public void footprintMultiLevel() {
        Car thisPolo = new Car("Polo", 2013,
                new Engine(1498.0, 250.0, 110.0, 17.5),
                new Battery("Amaron", LocalDate.of(2017, 4, 20)),
                new GpsUnit("Pom Pom", "Google", new Battery("Lithium-Ion",
                        LocalDate.of(2016, 10, 27))));

        Path path = Paths.get(location, jsonFile);
        Car thatPolo = null;
        try {
            Files.write(path, Marshaller.apply(thisPolo).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        thatPolo = (Car) Unmarshaller.apply(location, jsonFile);
        assertTrue("this polo and that polo should be the same", thisPolo.equals(thatPolo));
    }
}
