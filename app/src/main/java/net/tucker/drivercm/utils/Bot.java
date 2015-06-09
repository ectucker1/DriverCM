package net.tucker.drivercm.utils;

import net.tucker.drivercm.botshell.*;
import net.tucker.drivercm.exceptions.PartNotDefinedException;

/**
 * Created by Ethan on 6/8/2015.
 */
public class Bot {

    /*
     Bot: The class for all information needed to drive the robot. This does not include control of arms
    */

    //The robot's gyro sensor
    Sensor gyro;

    //The robot's left motor
    DcMotor left;

    //The robot's right motor
    DcMotor right;

    //A special motor, eg. an H Drive
    DcMotor special;

    //Number of encoder units in one rotation
    public static final int rotation = 1440;

    //Circumference of a robot wheel
    private float wheelCircumference = 31.902f;

    //Default gyro sensor offset
    private int offset = 598;

    //Create a new Bot object. The gyro can be null if it's not being used. The special can be null if using pure tank drive.
    public Bot(DcMotor left, DcMotor right, DcMotor special, Sensor gyro, float wheelCircumference)
    {
        this.left = left;
        this.right = right;
        this.special = special;
        this.wheelCircumference = wheelCircumference;
        if(gyro != null) {
            this.gyro = gyro;
            try {
                calibrateGyro(5);
                //Will never be thrown
            } catch (PartNotDefinedException e) {
                e.printStackTrace();
            }
        }
    }

    //Converts cenimeters to encoder units
    public long centimetersToUnits(float centimeters) {
        float rotationPerCm = rotation / wheelCircumference;
        return Math.round(rotationPerCm * centimeters);
    }

    //Converts encoder units to cenimeters
    public float unitsToCentimeters(long units) {
        float cmPerRotation = wheelCircumference / rotation;// .02 "cm per units"
        return cmPerRotation * units;
    }

    //Get the robot's left motor
    public DcMotor getLeftMotor()
    {
        return left;
    }

    //Get the robot's right motor
    public DcMotor getRightMotor()
    {
        return right;
    }

    //Get an array with both drive motors
    public DcMotor[] getBothMotors()
    {
        return new DcMotor[] {left, right};
    }

    //Get the robot's special motor
    public DcMotor getSpecialMotor() {
        if(special == null)
            throw new PartNotDefinedException("No special motor defined");

        return special;
    }

    //Set the speed of the left motor
    public void setLeftSpeed(int speed)
    {
        left.setMotorSpeed(speed);
    }

    //Set the speed of the right motor
    public void setRightSpeed(int speed)
    {
        right.setMotorSpeed(speed);
    }

    public void setBothSpeeds(int speed)
    {
        left.setMotorSpeed(speed);
        right.setMotorSpeed(speed);
    }

    //Set the speed of the special motor
    public void setSpecialSpeed(int speed) {
        if(special == null)
            throw new PartNotDefinedException("No special motor defined");

        special.setMotorSpeed(speed);
    }

    //Calibrate the gyro sensor by averaging reading for a turn rate of 0.
    public void calibrateGyro(int passes) {
        if(gyro == null)
            throw new PartNotDefinedException("No gyro defined");

        int total = 0;
        for(int i = 0; i < passes; i++)
        {
            total += gyro.getValue();
        }
        offset = total / passes;
    }

    //Read the gyro sensor's value
    public int getGyroValue()
    {
        if(gyro == null)
            throw new PartNotDefinedException("No gyro defined");

        return gyro.getValue() - offset;
    }

}