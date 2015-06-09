package net.tucker.drivercm.drive.units;

/**
 * Created by Ethan on 6/9/2015.
 */
public class DegreeUnit implements GyroBasedUnit {

    float degrees;

    public DegreeUnit(float degrees)
    {
        this.degrees = degrees;
    }

    @Override
    public float toDegrees() {
        return degrees;
    }

    @Override
    public float getValue() {
        return degrees;
    }

    @Override
    public void setValue(float degrees) {
        this.degrees = degrees;
    }

    @Override
    public Type getType() {
        return Type.TURN;
    }
}
