package net.tucker.drivercm.drive.units;

/**
 * Created by Ethan on 6/9/2015.
 */
public class RadianUnit implements GyroBasedUnit {

    float rads;

    public RadianUnit(float rads)
    {
        this.rads = rads;
    }

    @Override
    public float toDegrees() {
        return (float)Math.toDegrees(rads);
    }

    @Override
    public float getValue() {
        return rads;
    }

    @Override
    public void setValue(float rads) {
        this.rads = rads;
    }

    @Override
    public Type getType() {
        return Type.TURN;
    }

}
