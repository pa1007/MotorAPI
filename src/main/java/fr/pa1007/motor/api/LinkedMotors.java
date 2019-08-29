package fr.pa1007.motor.api;

/**
 * This class create list of {@link fr.pa1007.motor.api.Motor} and connect themselves, can trigger all motors at one time <br>
 *
 * See their Python API here : <a href="https://github.com/sbcshop/MotorShield">https://github.com/sbcshop/MotorShield</a>
 *
 * @author pa1007
 */
public class LinkedMotors {

    private Motor[] motors;

    public LinkedMotors(Motor... motors) {
        if (motors == null || motors.length == 0) {
            throw new NullPointerException("No motors linked between");
        }
        this.motors = motors;
    }

    public void forward() {
        for (Motor m : motors) {
            m.forward();
        }
    }

    public void changeSpeed(int speed) {
        for (Motor m : motors) {
            m.changeSpeed(speed);
        }
    }

    public void reverse() {
        for (Motor m : motors) {
            m.reverse();
        }
    }

    public void forward(int speed) {
        for (Motor m : motors) {
            m.forward(speed);
        }
    }

    public void reverse(int speed) {
        for (Motor m : motors) {
            m.reverse(speed);
        }
    }

    public void test() throws InterruptedException {
        for (Motor m : motors) {
            m.getArrow().on();
        }
        Thread.sleep(1000);
        unTest();
    }

    public void unTest() {
        for (Motor m : motors) {
            m.getArrow().off();
        }
    }

    public void stop() {
        for (Motor m : motors) {
            m.stop();
        }
    }
}