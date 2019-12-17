
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pi
 */
public class sensor {
    //GPIO Pins

    private static GpioPinDigitalOutput sensorTriggerPin;
    private static GpioPinDigitalInput sensorEchoPin;

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        final GpioController gpio = GpioFactory.getInstance();
        // Trigger pin as OUTPUT
        sensorTriggerPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
        // Echo pin as INPUT
        sensorEchoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);

        GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        ledPin.setShutdownOptions(true, PinState.LOW);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                sensorTriggerPin.high(); // Make trigger pin HIGH
                try {
                    Thread.sleep((long) 0.01);// Delay for 10 microseconds
                } catch (InterruptedException ex) {
                    Logger.getLogger(sensor.class.getName()).log(Level.SEVERE, null, ex);
                }
                sensorTriggerPin.low(); //Make trigger pin LOW

                while (sensorEchoPin.isLow()) { //Wait until the ECHO pin gets HIGH

                }
                long startTime = System.nanoTime(); // Store the surrent time to calculate ECHO pin HIGH time.
                while (sensorEchoPin.isHigh()) { //Wait until the ECHO pin gets LOW

                }
                long endTime = System.nanoTime(); // Store the echo pin HIGH end time to calculate ECHO pin HIGH time.

                double distance = ((((endTime - startTime) / 1e3) / 2) / 29.1);
                System.out.println(distance);
                if (distance < 10) {
                    //System.out.println("menor que 5cm.");
                    ledPin.high();
                } else {
                    ledPin.low();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

}
