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
        double tgtPowerTurn;
        double tgtPowerStrafe;

        if (opModeIsActive()) {

            while (opModeIsActive()) {
                tgtPowerTurn = -this.gamepad1.left_stick_x;
                tgtPower = -this.gamepad1.left_stick_y;
                tgtPowerStrafe = -this.gamepad1.right_stick_x;

                frontleft.setPower(tgtPower);
                backleft.setPower(-tgtPower);
                frontright.setPower(tgtPower);
                backright.setPower(-tgtPower);

                frontleft.setPower(-tgtPowerTurn);
                backleft.setPower(tgtPowerTurn);
                frontright.setPower(tgtPowerTurn);
                backright.setPower(-tgtPowerTurn);

                frontleft.setPower(-tgtPowerStrafe);
                backleft.setPower(-tgtPowerStrafe);
                frontright.setPower(tgtPowerStrafe);
                backright.setPower(tgtPowerStrafe);

                telemetry.addData("Status", "walking");
                telemetry.addData("speed", frontleft.getPower());
                telemetry.update();
            }
        }
    }
}