/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class constants {
    public final static int armMotorID = 30; 
    public final static int armMotorSlaveID = 31;
    public final static int cargoMotorID = 18; 
    public final static int hatchMotorID = 22;

    public final static int right1 = 3;
    public final static int right2 = 4;
    public final static int right3 = 5;
    public final static int left1 = 2;
    public final static int left2 = 1;
    public final static int left3 = 21;

    //switches
    public final static int armEndStop = 0;
    public final static int cargoLimitSwitch = 1;

    //arm closed loop config params
    public static int armP = 0;
    public static int armI = 0;
    public static int armD = 0;
    public static int armFF = 0;

    //arm levels
    public final static int stowHeight = 0;
    public final static int cargoIntakeHeight = 0;
    public final static int hatchHeight = 0;
    public final static int scoreCargoHeight = 0;


}
