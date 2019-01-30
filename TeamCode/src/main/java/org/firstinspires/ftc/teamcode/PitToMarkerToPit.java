package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name = "Pit To Marker To Pit")

public class PitToMarkerToPit extends LinearOpMode {
	
	// Defines hardware
	private DcMotor linearSlide;
	private DcMotor leftDrive;
	private DcMotor rightDrive;
	private CRServo mainServo;
	private Servo markerServo;
	
	private double position_mainServo = 0.7; // Starts servo at position
	private double position_markerServo = 0.0;
	
	private void run() {
		linearSlide.setPower(1);
		sleep(3000);
		
		linearSlide.setPower(0);
		mainServo.setPower(1);
		sleep(200);
		
		leftDrive.setPower(-0.7);
		rightDrive.setPower(-0.7);
		sleep(500);
		mainServo.setPower(0);
		sleep(1000);
		
		leftDrive.setPower(0.0);
		rightDrive.setPower(0.0);
		linearSlide.setPower(-1);
		sleep(3000);
		
		linearSlide.setPower(0);
		leftDrive.setPower(0.7);
		rightDrive.setPower(-0.7);
		sleep(1700);
		
		leftDrive.setPower(-0.7);
		rightDrive.setPower(-0.7);
		sleep(3200);
		
		leftDrive.setPower(0.7);
		rightDrive.setPower(-0.7);
		sleep(1450);
		
		leftDrive.setPower(-0.7);
		rightDrive.setPower(-0.7);
		sleep(4600);
		
		leftDrive.setPower(0.0);
		rightDrive.setPower(0.0);
		markerServo.setPosition(1.0);
		sleep(500);
		
		leftDrive.setPower(0.7);
		rightDrive.setPower(0.7);
		sleep(4600);
		
		leftDrive.setPower(-0.7);
		rightDrive.setPower(0.7);
		sleep(1200);
		
		leftDrive.setPower(0.7);
		rightDrive.setPower(0.7);
		sleep(750);
		
		leftDrive.setPower(0.7);
		rightDrive.setPower(-0.7);
		sleep(1000);
		
		leftDrive.setPower(0.7);
		rightDrive.setPower(0.7);
		sleep(1000);
		
		stop();
	}
	
	// Main function
	@Override
	public void runOpMode() {

		// Updates telemetry (log) to show it is running
		telemetry.addData("Status", "Updated!");
		telemetry.update();

		// Initializes hardware
        linearSlide = hardwareMap.dcMotor.get("linearSlide");
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        mainServo = hardwareMap.crservo.get("mainServo");
        markerServo = hardwareMap.servo.get("markerServo");

		leftDrive.setDirection(DcMotor.Direction.REVERSE);
		rightDrive.setDirection(DcMotor.Direction.FORWARD);
//		mainServo.setPosition(position_mainServo);
		markerServo.setPosition(position_markerServo);
		
		waitForStart();
		
		// Runs main function
		run();
	}
}
