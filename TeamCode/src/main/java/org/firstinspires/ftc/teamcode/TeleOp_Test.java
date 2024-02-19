package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;




@TeleOp

public class TeleOp_Test extends LinearOpMode {
    private DcMotor backleft;
    private DcMotor frontleft;
    private DcMotor backright;
    private DcMotor frontright;


    @Override
    public void runOpMode() {

        double tgtPower = -this.gamepad1.left_stick_y;
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        frontright = hardwareMap.get(DcMotor.class, "frontright");

        frontleft.setPower(tgtPower);
        backleft.setPower(tgtPower);
        frontright.setPower(tgtPower);
        backright.setPower(tgtPower);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("speed", frontleft.getPower());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}