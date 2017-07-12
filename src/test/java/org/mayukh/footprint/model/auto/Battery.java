package org.mayukh.footprint.model.auto;

import java.time.LocalDate;

/**
 * Created by mayukh42 on 7/10/2017.
 *
 * POJO class for serialization
 */
public class Battery {

    private String name;
    private LocalDate manufactured;
    private Double chargeLeft;

    public Battery(String name, LocalDate manufactured) {
        this.name = name;
        this.manufactured = manufactured;
        this.chargeLeft = 20.0;
    }

    public Battery() {
    }

    public void charge() {
        if (this.chargeLeft <= 90.0) this.chargeLeft += 10.0;
    }

    @Override
    public String toString() {
        return "Battery{" + name + " (" + manufactured + ") @ " + chargeLeft + "%}";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufactured(LocalDate manufactured) {
        this.manufactured = manufactured;
    }

    public void setChargeLeft(Double chargeLeft) {
        this.chargeLeft = chargeLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Battery battery = (Battery) o;

        if (name != null ? !name.equals(battery.name) : battery.name != null) return false;
        if (manufactured != null ? !manufactured.equals(battery.manufactured) : battery.manufactured != null)
            return false;
        return chargeLeft != null ? chargeLeft.equals(battery.chargeLeft) : battery.chargeLeft == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (manufactured != null ? manufactured.hashCode() : 0);
        result = 31 * result + (chargeLeft != null ? chargeLeft.hashCode() : 0);
        return result;
    }
}
