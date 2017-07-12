package org.mayukh.footprint;

import org.junit.Test;
import org.mayukh.footprint.model.auto.Battery;
import org.mayukh.footprint.model.auto.Car;
import org.mayukh.footprint.model.auto.Engine;
import org.mayukh.footprint.model.auto.GpsUnit;

import java.time.LocalDate;

/**
 * Created by mayukh42 on 7/11/2017.
 *
 * Marshaller tests
 */
public class MarshallerTest {

    @Test
    public void testMarshallSimple() {
        Battery amaron = new Battery("Amaron", LocalDate.of(2017, 4, 20));
        System.out.println(Marshaller.apply(amaron));

        Engine tdi = new Engine(1498.0, 250.0, 110.0, 17.5);
        System.out.println(Marshaller.apply(tdi));
    }

    @Test
    public void testMarshallerNested() {
        Battery amaron = new Battery("Amaron", LocalDate.of(2017, 4, 20));
        Engine tdi = new Engine(1498.0, 250.0, 110.0, 17.5);
        GpsUnit gps = new GpsUnit("Pom Pom", "Google", new Battery("Lithium-Ion",
                LocalDate.of(2016, 8, 20)));

        Car polo = new Car("Polo", 2013, tdi, amaron, gps);
        System.out.println(Marshaller.apply(polo));
    }

    @Test
    public void testMarshallerNullFields() {
        Battery amaron = new Battery("Amaron", LocalDate.of(2017, 4, 20));
        Engine tdi = new Engine(1498.0, 250.0, 110.0, 17.5);

        Car polo = new Car("Polo", 2013, tdi, amaron, null);
        System.out.println(Marshaller.apply(polo));
    }

    @Test
    public void testOneLevelNestedPojo() {
        GpsUnit pompom = new GpsUnit("Pom Pom", "Google", new Battery("Lithium-Ion",
                LocalDate.of(2016, 8, 20)));
        System.out.println(Marshaller.apply(pompom));
    }
}
