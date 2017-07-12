package org.mayukh.footprint.model.auto;

/**
 * Created by mayukh42 on 7/10/2017.
 *
 * POJO class for serialization
 */
public class Engine {

    private Double displacement;
    private Double torq;
    private Double power;
    private Double fuelEff;

    public Engine(Double displacement, Double torq, Double power, Double fuelEff) {
        this.displacement = displacement;
        this.torq = torq;
        this.power = power;
        this.fuelEff = fuelEff;
    }

    public Engine() {
    }

    @Override
    public String toString() {
        return "Engine{" + displacement + " cc, " + power + " HP/ " + torq + " Nm, " + fuelEff + " kmpl}";
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public void setTorq(Double torq) {
        this.torq = torq;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public void setFuelEff(Double fuelEff) {
        this.fuelEff = fuelEff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (displacement != null ? !displacement.equals(engine.displacement) : engine.displacement != null)
            return false;
        if (torq != null ? !torq.equals(engine.torq) : engine.torq != null) return false;
        if (power != null ? !power.equals(engine.power) : engine.power != null) return false;
        return fuelEff != null ? fuelEff.equals(engine.fuelEff) : engine.fuelEff == null;
    }

    @Override
    public int hashCode() {
        int result = displacement != null ? displacement.hashCode() : 0;
        result = 31 * result + (torq != null ? torq.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (fuelEff != null ? fuelEff.hashCode() : 0);
        return result;
    }
}
