package net.tucker.drivercm.drive.units;

/**
 * Created by Ethan on 6/9/2015.
 */
public class MsecUnit implements TimeBasedUnit {

    long msecs;

    public MsecUnit(long msecs)
    {
        this.msecs = msecs;
    }

    @Override
    public long toMsecs()
    {
        return msecs;
    }

    @Override
    public float getValue() {
        return msecs;
    }

    @Override
    public void setValue(float msecs) {
        this.msecs = Math.round(msecs);
    }

    @Override
    public Unit.Type getType() {
        return Unit.Type.GENERIC;
    }

}
