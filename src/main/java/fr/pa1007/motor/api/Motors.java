package fr.pa1007.motor.api;

import com.pi4j.io.gpio.RaspiPin;


/**
 * This class can create the motors easily
 * <br>
 * See their Python API here : <a href="https://github.com/sbcshop/MotorShield">https://github.com/sbcshop/MotorShield</a>
 *
 * @author pa1007
 */
public class Motors {

    public static final Motor MOTOR_4 = new Motor(RaspiPin.GPIO_26, RaspiPin.GPIO_10, RaspiPin.GPIO_11, Arrow.MOTOR_4);
    public static final Motor MOTOR_3 = new Motor(RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, Arrow.MOTOR_3);
    public static final Motor MOTOR_2 = new Motor(RaspiPin.GPIO_06, RaspiPin.GPIO_04, RaspiPin.GPIO_05, Arrow.MOTOR_2);
    public static final Motor MOTOR_1 = new Motor(RaspiPin.GPIO_00, RaspiPin.GPIO_03, RaspiPin.GPIO_02, Arrow.MOTOR_1);

    private Motors() { }

}

