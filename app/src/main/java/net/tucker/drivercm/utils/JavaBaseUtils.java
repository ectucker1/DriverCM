package net.tucker.drivercm.utils;

/**
 * Created by Ethan on 6/8/2015.
 */
public class JavaBaseUtils {

    public static void sleep(long msecs)
    {
        try {
            Thread.sleep(msecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
