package org.example.lab04;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class BasicController {

    private final DevicesFactory devicesFactory = new DevicesFactory();
    private final DevicesList devicesList = new DevicesList();

    private final String returnButton = "<br><a href='/'><button>Return</button></a>";
    private final DecimalFormat cutDecimal = new DecimalFormat("0.##");

    private String generateText(Device device) {
        return String.format("<h1>%s was created!</h1>"
                + "Voltage: %s V <br>"
                + "Current: %s A <br>"
                + "<br>Power: %s W <br>",
                StringUtils.capitalize(device.getType()),
                cutDecimal.format(device.getVoltage()),
                cutDecimal.format(device.getCurrent()),
                cutDecimal.format(device.calculatePower())
        ) + returnButton;
    }

    @GetMapping({"/lightbulb", "/engine", "/heater"})
    public String warning() {
        return "<h1>Error</h1>"
                + "Please use the form on the main page to submit device parameters."
                + returnButton;
    }

    @PostMapping("/lightbulb")
    public String lightbulb(@RequestParam double voltage, @RequestParam double current) {

        Device device = devicesFactory.createDevice(voltage,current,"lightbulb");
        devicesList.addNewDeviceToList(device);

        return generateText(device);
    }

    @PostMapping("/engine")
    public String engine(@RequestParam double voltage, @RequestParam double current) {

        Device device = devicesFactory.createDevice(voltage,current,"engine");
        devicesList.addNewDeviceToList(device);

        return generateText(device);
    }

    @PostMapping("/heater")
    public String heater(@RequestParam double voltage, @RequestParam double current) {

        Device device = devicesFactory.createDevice(voltage,current,"heater");
        devicesList.addNewDeviceToList(device);

        return generateText(device);
    }

    @GetMapping("/list")
    public DevicesList list(){
        return devicesList;
    }

}
