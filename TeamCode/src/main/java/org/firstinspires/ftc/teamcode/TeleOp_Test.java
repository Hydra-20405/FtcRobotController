package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class TeleOp_Test extends LinearOpMode {
    private DcMotor backleft;
    private DcMotor frontleft;
    private DcMotor backright;
    private DcMotor frontright;


    @Override
    public void runOpMode() {
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        frontright = hardwareMap.get(DcMotor.class, "frontright");

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower;

        tgtPower = -this.gamepad1.left_stick_y;

        while (opModeIsActive()) {

            frontleft.setPower(tgtPower);
            backleft.setPower(tgtPower);
            frontright.setPower(tgtPower);
            backright.setPower(tgtPower);

            telemetry.addData("Status", "walking");
            telemetry.addData("speed", frontleft.getPower());
            telemetry.update();
        }
    }
}