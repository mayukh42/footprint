package org.mayukh.footprint.model.auto;

/**
 * Created by mayukh42 on 7/10/2017.
 *
 * POJO class for serialization
 */
public class Car {

    private String name;
    private Integer mfg;
    private Engine engine;
    private Battery battery;
    private GpsUnit gps;

    public Car(String name, Integer mfg, Engine engine, Battery battery, GpsUnit gps) {
        this.name = name;
        this.mfg = mfg;
        this.engine = engine;
        this.battery = battery;
        this.gps = gps;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" + name + " (" + mfg + "), " + engine + ", " + battery +
                (gps != null ? " with " + gps : "") +
                "}";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMfg(Integer mfg) {
        this.mfg = mfg;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public void setGps(GpsUnit gps) {
        this.gps = gps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        if (mfg != null ? !mfg.equals(car.mfg) : car.mfg != null) return false;
        if (engine != null ? !engine.equals(car.engine) : car.engine != null) return false;
        if (battery != null ? !battery.equals(car.battery) : car.battery != null) return false;
        return gps != null ? gps.equals(car.gps) : car.gps == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (mfg != null ? mfg.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (gps != null ? gps.hashCode() : 0);
        return result;
    }
}
