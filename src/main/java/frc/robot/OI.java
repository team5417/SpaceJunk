/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.moveArm;
import frc.robot.commands.zeroArm;
import frc.robot.commands.commandGroups.intake;
import frc.robot.commands.commandGroups.outtake;
import frc.robot.commands.commandGroups.setIntakeCargo;
import frc.robot.commands.commandGroups.setIntakeHatch;

/**
 * Add your docs here.
 */
public class OI {
    private XboxController xboxController = new XboxController(0);
    private Hand rightHand = Hand.kRight; private Hand leftHand  = Hand.kLeft;


    public OI() {

        //assigning buttons to things
        JoystickButton aPad = new JoystickButton(xboxController,1);
		JoystickButton bPad = new JoystickButton(xboxController,2);
		JoystickButton xPad = new JoystickButton(xboxController,3);
		JoystickButton yPad = new JoystickButton(xboxController,4);
		
		JoystickButton leftBump = new JoystickButton(xboxController, 5);
		JoystickButton rightBump = new JoystickButton(xboxController, 6);

		JoystickButton startButton = new JoystickButton(xboxController, 7);
		JoystickButton menuButton = new JoystickButton(xboxController, 8);

		JoystickButton leftJoystickButton = new JoystickButton(xboxController, 9);
		JoystickButton rightJoystickButton = new JoystickButton(xboxController, 10);
    
        
        //assigning commands to buttons presses/releases
        //menuButton.whenPressed(new zeroArm());

        // aPad.whileHeld(new setIntakeCargo());
        // bPad.whileHeld(new setIntakeHatch());
        // xPad.whileHeld(new moveArm(constants.scoreCargoHeight));
        // yPad.whileHeld(new moveArm(constants.hatchHeight));
        leftBump.whileHeld(new outtake());
        rightBump.whileHeld(new intake());
        


    }
    public double leftSpeed() {
        return xboxController.getY(leftHand);
    }
    public double rightSpeed() {
        return xboxController.getY(rightHand);
    }

    public double armSpeed() {
        return (xboxController.getTriggerAxis(leftHand) - xboxController.getTriggerAxis(rightHand)) * .8;
    }
}
