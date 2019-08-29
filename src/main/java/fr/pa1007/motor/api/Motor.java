package fr.pa1007.motor.api;

import com.pi4j.io.gpio.*;

/**
 * This class refers to a motor controlled by the sb components motor shield <br>
 *
 * See their Python API here : <a href="https://github.com/sbcshop/MotorShield">https://github.com/sbcshop/MotorShield</a>
 *
 * @author pa1007
 */
public class Motor {

    /**
     * We need a controller for adding the Pin
     */
    private final GpioController gpio = GpioFactory.getInstance();

    /**
     * The PWM output pin.
     *
     * @since 0.1
     */
    private GpioPinPwmOutput pwmOutput;

    /**
     * The pin for the pwm GPIO.
     *
     * @since 0.1
     */
    private Pin pwmPin;

    /**
     * The output digitam.
     *
     * @since 0.1
     */
    private GpioPinDigitalOutput forwardOutput;

    /**
     * The Output for reverse.
     *
     * @since 0.1
     */
    private GpioPinDigitalOutput reverseOutput;

    /**
     * The forward pin.
     *
     * @since 0.1
     */
    private Pin forwardPin;

    /**
     * The reverse pin.
     *
     * @since 0.1
     */
    private Pin reversePin;

    /**
     * The arrow  connected to the motor.
     *
     * @since 0.1
     */
    private Arrow arrow;

    /**
     * For keeping the last speed input
     */
    private int pwm;

    public Motor(Pin pwmPin, Pin forwardPin, Pin reversePin, Arrow arrow) {
        this.pwmPin = pwmPin;
        this.forwardPin = forwardPin;
        this.reversePin = reversePin;
        init();
        this.arrow = arrow;
    }

    /**
     * @return The Output for reverse.
     * @since 0.1
     */
    public GpioPinDigitalOutput getReverseOutput() {
        return this.reverseOutput;
    }

    /**
     * Sets the <code>reverseOutput</code> field.
     *
     * @param reverseOutput The Output for reverse.
     * @since 0.1
     */
    public void setReverseOutput(GpioPinDigitalOutput reverseOutput) {
        this.reverseOutput = reverseOutput;
    }

    /**
     * @return The output digitam.
     * @since 0.1
     */
    public GpioPinDigitalOutput getForwardOutput() {
        return this.forwardOutput;
    }

    /**
     * Sets the <code>forwardOutput</code> field.
     *
     * @param forwardOutput The output digitam.
     * @since 0.1
     */
    public void setForwardOutput(GpioPinDigitalOutput forwardOutput) {
        this.forwardOutput = forwardOutput;
    }

    /**
     * @return The reverse pin.
     * @since 0.1
     */
    public Pin getReversePin() {
        return this.reversePin;
    }

    /**
     * Sets the <code>reversePin</code> field.
     *
     * @param reversePin The reverse pin.
     * @since 0.1
     */
    public void setReversePin(Pin reversePin) {
        this.reversePin = reversePin;
    }

    /**
     * @return The forward pin.
     * @since 0.1
     */
    public Pin getForwardPin() {
        return this.forwardPin;
    }

    /**
     * Sets the <code>forwardPin</code> field.
     *
     * @param forwardPin The forward pin.
     * @since 0.1
     */
    public void setForwardPin(Pin forwardPin) {
        this.forwardPin = forwardPin;
    }

    /**
     * @return The pin for the pwm GPIO.
     * @since 0.1
     */
    public Pin getPwmPin() {
        return this.pwmPin;
    }

    /**
     * Sets the <code>pwmPin</code> field.
     *
     * @param pwmPin The pin for the pwm GPIO.
     * @since 0.1
     */
    public void setPwmPin(Pin pwmPin) {
        this.pwmPin = pwmPin;
    }

    /**
     * @return The arrow  connected to the motor.
     * @since 0.1
     */
    public Arrow getArrow() {
        return this.arrow;
    }

    /**
     * Sets the <code>arrow</code> field.
     *
     * @param arrow The arrow  connected to the motor.
     * @since 0.1
     */
    public void setArrow(Arrow arrow) {
        this.arrow = arrow;
    }

    /**
     * @return The PWM pin.
     * @since 0.1
     */
    public GpioPinPwmOutput getGpioPin() {
        return this.pwmOutput;
    }

    /**
     * Sets the <code>pwmOutput</code> field.
     *
     * @param pin The PWM pin.
     * @since 0.1
     */
    public void setGdpioPin(GpioPinPwmOutput pin) {
        this.pwmOutput = pin;
    }


    public void forward() {
        forward(pwm);
    }

    public void reverse() {
        reverse(pwm);
    }

    public void forward(int speed) {
        changeSpeed(speed);
        reverseOutput.setState(PinState.LOW);
        forwardOutput.setState(PinState.HIGH);
    }

    public void reverse(int speed) {
        changeSpeed(speed);
        forwardOutput.setState(PinState.LOW);
        reverseOutput.setState(PinState.HIGH);
    }

    public void changeSpeed(int speed) {
        pwmOutput.setPwm(speed);
        pwm = speed;
    }

    public void stop() {
        pwmOutput.setPwm(0);
        forwardOutput.setState(PinState.LOW);
        reverseOutput.setState(PinState.LOW);
    }

    public void forwardWithoutChange(int speed) {
        pwmOutput.setPwm(speed);
        reverseOutput.setState(PinState.LOW);
        forwardOutput.setState(PinState.HIGH);
    }

    public void reverseWithoutChange(int speed) {
        pwmOutput.setPwm(speed);
        forwardOutput.setState(PinState.LOW);
        reverseOutput.setState(PinState.HIGH);
    }

    public void unBound() {
        stop();
        forwardOutput.unexport();
        reverseOutput.unexport();
        pwmOutput.unexport();
    }

    private void init() {
        forwardOutput = gpio.provisionDigitalOutputPin(forwardPin, "Forward", PinState.LOW);
        reverseOutput = gpio.provisionDigitalOutputPin(reversePin, "reverse", PinState.LOW);
        if (pwmPin == RaspiPin.GPIO_26) {
            pwmOutput = gpio.provisionPwmOutputPin(pwmPin, "PWM", 50);
            pwmOutput.setPwmRange(100);
        }
        else {
            pwmOutput = gpio.provisionSoftPwmOutputPin(pwmPin, "PWM", 50);
        }
    }
}
