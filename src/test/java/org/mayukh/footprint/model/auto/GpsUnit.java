package org.mayukh.footprint.model.auto;

/**
 * Created by mayukh42 on 7/11/2017.
 */
public class GpsUnit {

    private String make;
    private String provider;
    private Battery battery;

    public GpsUnit(String make, String provider, Battery battery) {
        this.make = make;
        this.provider = provider;
        this.battery = battery;
    }

    public GpsUnit() {
    }

    @Override
    public String toString() {
        return "GpsUnit{" + make + " provided by " + provider + ", running on " + battery + "}";
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GpsUnit gpsUnit = (GpsUnit) o;

        if (make != null ? !make.equals(gpsUnit.make) : gpsUnit.make != null) return false;
        if (provider != null ? !provider.equals(gpsUnit.provider) : gpsUnit.provider != null) return false;
        return battery != null ? battery.equals(gpsUnit.battery) : gpsUnit.battery == null;
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        return result;
    }
}
