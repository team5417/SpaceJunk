/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants;;

public class zeroArm extends Command {

  boolean isFinished;


  public zeroArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    isFinished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!Robot.arm.getClosedLoopEnabled()){ //if the arm isnt configured for closed loop yet, zero the arm with voltage mode
      Robot.arm.setArmPercent(-.1);
      if(Robot.arm.getLimitSwitch()){
        Robot.arm.setArmEncoder(0);
        Robot.arm.configClosedLoop();
        isFinished = true;
      }
    }
    else { //if arm IS configured for closed loop, go to the zero point, and reset to new 0
      Robot.arm.setArmPosition(0.0);
      if(Robot.arm.getLimitSwitch()){
        Robot.arm.setArmEncoder(0);
        isFinished = true; //End command
      }
      else{
        Robot.arm.setArmEncoder(0);
        isFinished = true; //Prevents arm from resetting forever, just zero's and moves on
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.arm.setArmPosition(constants.stowHeight);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.arm.stopArm();
  }
}
