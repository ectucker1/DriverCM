package net.tucker.drivercm.drive.units;

import net.tucker.drivercm.utils.Bot;

/**
 * Created by Ethan on 6/9/2015.
 */
public class CentimeterUnit implements EncoderBasedUnit {

    float cm;

    public CentimeterUnit(float cm)
    {
        this.cm = cm;
    }

    @Override
    public float toEncoder(Bot bot) {
        return bot.centimetersToUnits(cm);
    }

    @Override
    public float getValue() {
        return cm;
    }

    @Override
    public void setValue(float value) {
        this.cm = cm;
    }

    @Override
    public Type getType() {
        return Type.DRIVE;
    }

}
