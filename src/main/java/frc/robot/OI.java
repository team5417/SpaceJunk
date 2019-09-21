/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Add your docs here.
 */
public class OI {
    private XboxController xboxController = new XboxController(0);



    public OI() {

        
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
    }
}
