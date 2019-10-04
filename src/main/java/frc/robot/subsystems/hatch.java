/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Solenoid solenoid = new Solenoid(1);
  VictorSPX hatchRollers = new VictorSPX(constants.hatchMotorID);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void toggleSolenoid(Boolean button){
    if(button){
     // solenoid.set(!solenoid.get());
    }
  }

  public void setHatchRollerPercent(Double power){
    hatchRollers.set(ControlMode.PercentOutput, power);
  }
}
