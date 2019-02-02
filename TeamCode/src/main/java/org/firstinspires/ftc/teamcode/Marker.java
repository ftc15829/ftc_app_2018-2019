package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//@Disabled
@Autonomous(name = "Marker")

public class Marker extends LinearOpMode {

    // Defines hardware
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor linearSlide;
    private CRServo linearServo;
    private Servo markerServo;

    private void drive(double power) {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
    }

    private void driveDistance(double revolutions, double power) {
        leftDrive.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightDrive.setMode(DcMotor.RunMode.RESET_ENCODERS);

        leftDrive.setTargetPosition((int) (revolutions * 1440));
        rightDrive.setTargetPosition((int) (revolutions * 1440));


        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        drive(power);

        while (leftDrive.isBusy() && rightDrive.isBusy()) {

        }

        stopDriving();

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    private void stopDriving() {
        drive(0);
    }

    private void lowerSlide() {
        /*
        lower slide and turn servo
         */
        driveDistance(2, 0.5);
        /*
        lower slide fully
         */
    }

    private void turn(double turnUnit, double power) {
        leftDrive.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightDrive.setMode(DcMotor.RunMode.RESET_ENCODERS);

        leftDrive.setTargetPosition((int) (turnUnit * 1440));
        rightDrive.setTargetPosition((int) (-turnUnit * 1440));


        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        drive(power);

        while (leftDrive.isBusy() && rightDrive.isBusy()) {

        }

        stopDriving();

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }


    private void run() {
        turn(1,1);
        stop();
    }

    @Override
    public void runOpMode() {

        // Updates telemetry (log) to show it is running
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initializes hardware
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        linearSlide = hardwareMap.dcMotor.get("linearSlide");
        linearServo = hardwareMap.crservo.get("linearServo");
        markerServo = hardwareMap.servo.get("markerServo");
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        markerServo.setPosition(0.0);

        waitForStart();

        // Runs main function
        run();
    }
}
