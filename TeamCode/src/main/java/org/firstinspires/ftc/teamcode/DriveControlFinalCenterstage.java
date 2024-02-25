package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriverControllerV8 (Blocks to Java)")
public class DriveControlFinalCenterstage extends LinearOpMode {


    private DcMotor frontright;
    private DcMotor frontleft;
    private DcMotor backright;
    private DcMotor backleft;
    private DcMotor hang;
    private DcMotor hang1;
    private DcMotor arm;
    private DcMotor arm2;
    private Servo handleft;
    private Servo handright;
    private Servo wrist;
    private Servo drone;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        double speedslower=1;
        float Speed;
        float Turn;
        float Strafe;

        frontright = hardwareMap.get(DcMotor.class, "frontright");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        hang = hardwareMap.get(DcMotor.class, "hang");
        hang1 = hardwareMap.get(DcMotor.class, "hang1");
        arm = hardwareMap.get(DcMotor.class, "arm");
        arm2 = hardwareMap.get(DcMotor.class, "arm2");
        handleft = hardwareMap.get(Servo.class, "handleft");
        handright = hardwareMap.get(Servo.class, "handright");
        wrist = hardwareMap.get(Servo.class, "wrist");
        drone = hardwareMap.get(Servo.class, "drone");

        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            frontright.setDirection(DcMotor.Direction.FORWARD);
            frontleft.setDirection(DcMotor.Direction.FORWARD);
            backright.setDirection(DcMotor.Direction.REVERSE);
            backleft.setDirection(DcMotor.Direction.REVERSE);
            while (opModeIsActive()) {
                // Put loop blocks here.
                Speed = -gamepad1.left_stick_y;
                Speed = (float) (Speed * speedslower);
                Turn = gamepad1.left_stick_x;
                Turn = (float) (Turn * speedslower);
                Strafe = gamepad1.right_stick_x;
                Strafe = (float) (Strafe * speedslower);
                frontleft.setPower(Speed + Turn + Strafe);
                frontright.setPower(Speed - (Turn + Strafe));
                backleft.setPower(Speed + (Turn - Strafe));
                backright.setPower(Speed - (Turn - Strafe));
                if (gamepad1.a) {
                    speedslower = 1;
                }
                if (gamepad1.b) {
                    speedslower = 0.4;
                }
                if (gamepad1.dpad_down) {
                    hang.setPower(1);
                    hang1.setPower(-1);
                } else {
                    hang.setPower(0);
                    hang1.setPower(0);
                }
                if (gamepad1.dpad_up) {
                    hang.setPower(-1);
                    hang1.setPower(1);
                } else {
                    hang.setPower(0);
                    hang1.setPower(0);
                }
                if (gamepad2.dpad_down) {
                    arm.setPower(0.5);
                } else {
                    arm.setPower(0);
                }
                if (gamepad2.dpad_down) {
                    arm2.setPower(-0.5);
                } else {
                    arm2.setPower(0);
                }
                if (gamepad2.dpad_up) {
                    arm.setPower(-0.5);
                } else {
                    arm.setPower(0);
                }
                if (gamepad2.dpad_up) {
                    arm2.setPower(0.5);
                } else {
                    arm2.setPower(0);
                }
                if (gamepad2.right_bumper) {
                    handleft.setPosition(0.85);
                }
                if (gamepad2.a) {
                    handleft.setPosition(0.4);
                }
                if (gamepad2.left_bumper) {
                    handright.setPosition(0.5);
                }
                if (gamepad2.a) {
                    handright.setPosition(1);
                }
                if (gamepad2.x) {
                    wrist.setPosition(0.66);
                }
                if (gamepad1.y) {
                    drone.setPosition(0.66);
                }
                if (gamepad2.b) {
                    wrist.setPosition(0.8);
                }
                if (gamepad2.y) {
                    wrist.setPosition(0.26);
                }
                telemetry.update();
            }
        }
    }
}