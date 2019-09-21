/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.commandGroups;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.constants;
import frc.robot.commands.intakeHatch;
import frc.robot.commands.moveArm;


public class setIntakeHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public setIntakeHatch() {
    addParallel(new moveArm(constants.hatchHeight));
    addParallel(new intakeHatch(true));
  }
}
