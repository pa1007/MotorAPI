package fr.pa1007.motor.api;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create list of {@link fr.pa1007.motor.api.Motor} and connect themselves, can trigger all motors at one time , add motor in 2 direction :
 * <il>
 *      <ul><code>GoodWay</code> go forward </ul>
 *      <ul><code>Reverse</code> go reverse </ul>
 *  </il>
 * <br>
 * See their Python API here : <a href="https://github.com/sbcshop/MotorShield">https://github.com/sbcshop/MotorShield</a>
 *
 * @author pa1007
 */
public class InvertedMotors {

    private List<Motor> goodWay;

    private List<Motor> reverse;


    public InvertedMotors() {
        goodWay = new ArrayList<>();
        reverse = new ArrayList<>();
    }

    public void addGoodWay(Motor m) {
        goodWay.add(m);
    }

    public void addReverse(Motor m) {
        reverse.add(m);
    }


    public void forward() {
        for (Motor m : goodWay) {
            m.forward();
        }
        for (Motor m : reverse) {
            m.reverse();
        }
    }

    public void forward(int speed) {
        for (Motor m : goodWay) {
            m.forward(speed);
        }
        for (Motor m : reverse) {
            m.reverse(speed);
        }
    }

    public void reverse() {
        for (Motor m : reverse) {
            m.forward();
        }
        for (Motor m : goodWay) {
            m.reverse();
        }
    }

    public void reverse(int speed) {
        for (Motor m : reverse) {
            m.forward(speed);
        }
        for (Motor m : goodWay) {
            m.reverse(speed);
        }
    }

    public void stop() {
        for (Motor m : reverse) {
            m.stop();
        }
        for (Motor m : goodWay) {
            m.stop();
        }
    }

    public void forwardWithoutChange(int speed) {
        for (Motor m : goodWay) {
            m.forwardWithoutChange(speed);
        }
        for (Motor m : reverse) {
            m.reverseWithoutChange(speed);
        }
    }
}
