// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final CANSparkMax leftmotor = new CANSparkMax(11, MotorType.kBrushed);
  private final CANSparkMax rightmotor = new CANSparkMax(12, MotorType.kBrushed);
  private final Joystick joystick = new Joystick(0);


  private double startTime;
  




   /* This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();

    if (time - startTime < 3){
    leftmotor.set(0.6);
    rightmotor.set(-0.6);
  } else {
    leftmotor.set(0.0);
    rightmotor.set(0.0);

  }

  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = - joystick.getRawAxis(1) * 0.6;
    double turn = joystick.getRawAxis(4) * 0.3;
    double left = speed + turn;
    double right = speed - turn;
    leftmotor.set(left);
    rightmotor.set(right);

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
