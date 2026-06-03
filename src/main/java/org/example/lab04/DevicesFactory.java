package org.example.lab04;

public class DevicesFactory {

    public Device createDevice(double voltage, double current, String type){

        switch (type.toLowerCase()) {
            case "lightbulb":
                return new Lightbulb(voltage, current);
            case "engine":
                return new Engine(voltage, current);
            case "heater":
                return new Heater(voltage, current);
            default:
                return null;
        }
    };
}
