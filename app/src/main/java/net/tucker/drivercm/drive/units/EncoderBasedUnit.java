package net.tucker.drivercm.drive.units;

import net.tucker.drivercm.utils.Bot;

/**
 * Created by Ethan on 6/9/2015.
 */
public interface EncoderBasedUnit extends Unit {

    public float toEncoder(Bot bot);

}
