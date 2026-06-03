package org.example.lab04;

import java.util.ArrayList;
import java.util.List;

public class DevicesList {

    private List<Device> devicesList = new ArrayList<Device>();

    public void addNewDeviceToList(Device device){
        devicesList.add(device);
    }

    public List<Device> getDevicesList() {
        return devicesList;
    }
}
