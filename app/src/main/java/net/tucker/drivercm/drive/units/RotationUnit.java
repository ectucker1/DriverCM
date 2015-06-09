package net.tucker.drivercm.drive.units;

import net.tucker.drivercm.utils.Bot;

/**
 * Created by Ethan on 6/9/2015.
 */
public class RotationUnit implements EncoderBasedUnit {

    float rotations;

    public RotationUnit(float rotations)
    {
        this.rotations = rotations;
    }

    @Override
    public float toEncoder(Bot bot) {
        return rotations * Bot.rotation;
    }

    @Override
    public float getValue() {
        return rotations;
    }

    @Override
    public void setValue(float rotations) {
        this.rotations = rotations;
    }

    @Override
    public Type getType() {
        return Type.GENERIC;
    }

}
