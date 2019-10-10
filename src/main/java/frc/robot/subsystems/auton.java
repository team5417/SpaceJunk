package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class auton extends TimedRobot{
  private static final int k_ticks_per_rev = 100;
  private static final double k_wheel_diameter = 3.0;
  private static final double k_max_velocity = 10;

  private static final int k_left_channel = 0;
  private static final int k_right_channel = 1;

  private static final int k_left_encoder_port = 0;
  private static final int k_right_encoder_port = 1;

  private static final int k_gyro_port = 0;

  private static final String k_path_name = "2019 Space Junk";

  private SpeedController m_left_motor;
  private SpeedController m_right_motor;

  private Encoder m_left_encoder;
  private Encoder m_right_encoder;

  private AnalogGyro m_gyro;

  private EncoderFollower m_left_follower;
  private EncoderFollower m_right_follower;
  
  private Notifier m_follower_notifier;

  @Override 
  public void robotInit(){
    m_left_motor = new TalonSRX(k_left_channel);
    m_right_motor = new Spark(k_right_channel);
    m_left_encoder = new Encoder(k_left_encoder_port_a, k_left_encoder_port_b);
    m_right_encoder = new Encoder(k_right_encoder_port_a, k_right_encoder_port_b);
    m_gyro = new AnalogGyro(k_gyro_port);
  }
}