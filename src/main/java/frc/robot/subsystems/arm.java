/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.constants;
import frc.robot.commands.armTrigger;

/**
 * Add your docs here.
 */
public class arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  //init motor controller
  CANSparkMax armMotor = new CANSparkMax(constants.armMotorID, MotorType.kBrushless);
  CANSparkMax armMotorSlave = new CANSparkMax(constants.armMotorSlaveID, MotorType.kBrushless);

  //init limit switch
  DigitalInput endStop = new DigitalInput(constants.armEndStop);
  //init PID controller for spark max
  CANPIDController armPIDController = armMotor.getPIDController();
  //init encoder that's on the neo for the spark max
  CANEncoder armEncoder = armMotor.getEncoder();

  
  //boolean to check if we have set up the arms closed loop paramaters yet, you can see this turned true in a function below
  public boolean armClosedLoop = false;


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new armTrigger());
  }

  public void configClosedLoop(){

    //configuring PID and Feed Foward constants, as well as other constants
    //Constants can be found in the constants.java folder
    armMotor.setIdleMode(IdleMode.kBrake);

    armPIDController.setP(constants.armP);
    armPIDController.setI(constants.armI);
    armPIDController.setD(constants.armD);
    armPIDController.setFF(constants.armFF);
    armPIDController.setOutputRange(-1, 1);

    armPIDController.setSmartMotionMaxVelocity(150, 0); //max rpm of neo

    armMotor.setSmartCurrentLimit(20);
    armMotorSlave.setSmartCurrentLimit(20);
    armClosedLoop = true; //setting flag that we have set up Closed loop parameters 
  }

  public void setArmPosition(Double armSetPoint){
    if(armClosedLoop){
      armPIDController.setReference(armSetPoint, ControlType.kSmartMotion);
    }
  }

  public void setArmPercent(Double power){
    armMotor.set(power);
    armMotorSlave.set(power);
    SmartDashboard.putNumber("Voltage", power);
    SmartDashboard.putNumber("Encoder", getArmPosition());
  }

  public void setArmEncoder(Integer setPoint){
    armEncoder.setPosition(setPoint);
  }

  public void stopArm(){
    armMotor.stopMotor();
  }

  public Double getArmCurrent(){
    return armMotor.getOutputCurrent();
  }

  public Double getArmPosition(){
    return armEncoder.getPosition();
  }

  public Boolean getLimitSwitch(){
    return endStop.get();
  }

  public Boolean getClosedLoopEnabled(){
    return armClosedLoop;
  }
}
