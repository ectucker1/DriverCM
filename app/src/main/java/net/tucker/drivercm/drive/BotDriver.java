package net.tucker.drivercm.drive;

import net.tucker.drivercm.botshell.DcMotor;
import net.tucker.drivercm.drive.units.EncoderBasedUnit;
import net.tucker.drivercm.drive.units.GyroBasedUnit;
import net.tucker.drivercm.drive.units.TimeBasedUnit;
import net.tucker.drivercm.utils.Bot;
import net.tucker.drivercm.utils.JavaBaseUtils;

/**
 * Created by Ethan on 6/8/2015.
 */
public class BotDriver {

   /*
   Drives the bot, equivalant to the orignal DriverCM
    */

    public static final int stop = 0;

    Bot bot;

    public BotDriver(Bot bot)
    {
        this.bot = bot;
    }

    //TODO Gyro stabilization
    public void drive(TimeBasedUnit time, int speed)
    {
        bot.setBothSpeeds(speed);

        JavaBaseUtils.sleep(time.toMsecs());

        bot.setBothSpeeds(stop);
    }

    //TODO Gyro stabilization
    public void drive(EncoderBasedUnit distance, int speed)
    {
        DcMotor left = bot.getLeftMotor();
        left.resetEncoder();

        bot.setBothSpeeds(speed);
        while(Math.abs(left.getEncoderValue()) < distance.toEncoder(bot));
        bot.setBothSpeeds(stop);
 
        left.resetEncoder();
    }

    public void turnLeft(TimeBasedUnit time, int speed, boolean extraPower)
    {
        bot.setRightSpeed(speed);//Right turns left
        if(extraPower)
            bot.setLeftSpeed(-speed);

        JavaBaseUtils.sleep(time.toMsecs());

        bot.setBothSpeeds(stop);
    }

    public void turnRight(TimeBasedUnit time, int speed, boolean extraPower)
    {
        bot.setLeftSpeed(speed);//Left turns right
        if(extraPower)
            bot.setRightSpeed(-speed);

        JavaBaseUtils.sleep(time.toMsecs());

        bot.setBothSpeeds(stop);
    }

    public void turnLeft(EncoderBasedUnit amount, int speed, boolean extraPower)
    {
        DcMotor right = bot.getRightMotor();
        right.resetEncoder();

        bot.setRightSpeed(speed);//Right turns left
        if(extraPower)
            bot.setLeftSpeed(-speed);

        while(Math.abs(right.getEncoderValue()) < amount.toEncoder(bot));

        bot.setBothSpeeds(stop);
    }

    public void turnRight(EncoderBasedUnit amount, int speed, boolean extraPower)
    {
        DcMotor left = bot.getLeftMotor();
        left.resetEncoder();

        bot.setLeftSpeed(speed);//Left turns right
        if(extraPower)
            bot.setRightSpeed(-speed);

        while(Math.abs(left.getEncoderValue()) < amount.toEncoder(bot));

        bot.setBothSpeeds(stop);
    }

    private void waitForGyro(GyroBasedUnit amount)
    {
        float degrees = amount.toDegrees();
        while(degrees > 0)
        {
            JavaBaseUtils.sleep(1000);
            degrees -= Math.abs(bot.getGyroValue());
        }
    }

    public void turnLeft(GyroBasedUnit amount, int speed, boolean extraPower)
    {
        bot.setRightSpeed(speed);//Right turns left
        if(extraPower)
            bot.setLeftSpeed(-speed);

        waitForGyro(amount);

        bot.setBothSpeeds(stop);
    }

    public void turnRight(GyroBasedUnit amount, int speed, boolean extraPower)
    {
        bot.setLeftSpeed(speed);//Left turns right
        if(extraPower)
            bot.setRightSpeed(-speed);

        waitForGyro(amount);

        bot.setBothSpeeds(stop);
    }

}
