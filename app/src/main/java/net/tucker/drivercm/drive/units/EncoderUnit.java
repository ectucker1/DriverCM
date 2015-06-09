package net.tucker.drivercm.drive.units;

import net.tucker.drivercm.utils.Bot;

/**
 * Created by Ethan on 6/9/2015.
 */
public class EncoderUnit implements EncoderBasedUnit {

    long units;

    public EncoderUnit(long units)
    {
        this.units = units;
    }

    @Override
    public float toEncoder(Bot bot) {
        return units;
    }

    @Override
    public float getValue() {
        return units;
    }

    @Override
    public void setValue(float value) {
        this.units = Math.round(value);
    }

    @Override
    public Type getType() {
        return Type.GENERIC;
    }
}
