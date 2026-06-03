package org.example.lab04;

public class Lightbulb implements Device
{
    private double voltage = 0;
    private double current = 0;

    @Override
    public double calculatePower(){
        return voltage * current;
    };

    @Override
    public String getType(){
        return "lightbulb";
    };

    @Override
    public double getVoltage() {
        return voltage;
    };

    @Override
    public double getCurrent() {
        return current;
    };

    public Lightbulb(double voltage, double current){
        this.voltage = voltage;
        this.current = current;
    };

}
