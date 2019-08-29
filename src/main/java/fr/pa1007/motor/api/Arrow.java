package fr.pa1007.motor.api;

import com.pi4j.io.gpio.*;

/**
 * The arrows are the arrow on the top of the board can activate them and deactivate them
 * <br>
 * See their Python API here : <a href="https://github.com/sbcshop/MotorShield">https://github.com/sbcshop/MotorShield</a>
 *
 * @author pa1007
 */
public class Arrow {

    /**
     * The Front arrow ( Facing the power entry)
     */
    public static final Arrow MOTOR_4 = new Arrow(RaspiPin.GPIO_23, "Motor 4");


    /**
     * The right arrow ( Facing the 40 pins)
     */
    public static final Arrow MOTOR_3 = new Arrow(RaspiPin.GPIO_24, "Motor 3");

    /**
     * The back arrow ( Facing the detection unit)
     */
    public static final Arrow MOTOR_2 = new Arrow(RaspiPin.GPIO_25, "Motor 2");

    /**
     * The left arrow ( Facing the motors connectors)
     */
    public static final Arrow MOTOR_1 = new Arrow(RaspiPin.GPIO_27, "Motor 1");

    private GpioPinDigitalOutput output;

    /**
     * Protected constructor
     *
     * @param pin  the pin of the arrow to turn it on
     * @param name the name of the connector
     */
    protected Arrow(Pin pin, String name) {
        GpioController gpio = GpioFactory.getInstance();
        this.output = gpio.provisionDigitalOutputPin(pin, name);
    }

    public void on() {
        output.setState(PinState.HIGH);
    }

    public void off() {
        output.setState(PinState.LOW);
    }

}
