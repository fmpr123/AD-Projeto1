/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.events;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodData;

/**
 *
 * @author Turma A
 */
public class DirectMethodCallback implements DeviceMethodCallback {

    // Define method response codes
    private static final int METHOD_SUCCESS = 200;
    private static final int METHOD_NOT_DEFINED = 404;
    private static final int INVALID_PARAMETER = 400;

    public int deviceDistance = 10;
    public String deviceAlarm="";

    private void setDeviceDistance(int distance) {
        System.out.println("Direct method # Setting device distance: " + distance);
        deviceDistance = distance;
    }
    
    private void setDeviceAlarm(String alarm) {
        System.out.println("Direct method # Setting device alarm status to: " + alarm);
        deviceAlarm = alarm;
    }

    @Override
    public DeviceMethodData call(String methodName, Object methodData, Object context) {
        DeviceMethodData deviceMethodData;
        String payload = new String((byte[]) methodData);
        switch (methodName) {
            case "setDeviceDistance": {
                int interval;
                try {
                    int status = METHOD_SUCCESS;
                    interval = Integer.parseInt(payload);
                    System.out.println(payload);
                    setDeviceDistance(interval);
                    deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
                } catch (NumberFormatException e) {
                    int status = INVALID_PARAMETER;
                    deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
                }
                break;
            }
            case "setDeviceAlarm": {
                String interval;
                try {
                    int status = METHOD_SUCCESS;
                    interval = payload;
                    System.out.println(payload);
                    setDeviceAlarm(interval);
                    deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
                } catch (NumberFormatException e) {
                    int status = INVALID_PARAMETER;
                    deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
                }
                break;
            }
            default: {
                int status = METHOD_NOT_DEFINED;
                deviceMethodData = new DeviceMethodData(status, "Not defined direct method " + methodName);
            }
        }
        return deviceMethodData;
    }
}
