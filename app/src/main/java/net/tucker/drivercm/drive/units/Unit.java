package net.tucker.drivercm.drive.units;

/**
 * Created by Ethan on 6/9/2015.
 */
public interface Unit {

    public enum Type {
        DRIVE, TURN, GENERIC
    }


    public float getValue();

    public void setValue(float value);

    public Type getType();

}
