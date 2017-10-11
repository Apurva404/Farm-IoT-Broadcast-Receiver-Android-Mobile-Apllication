package com.apurva.assignment.farmIotApp.util;



public class FanSprinklerState {
    // 0 = turned off
    // 1 = turned on
    private int fanState;
    private int sprinklerState;

    private static FanSprinklerState state = new FanSprinklerState();

    private FanSprinklerState() {
        fanState = 0;
        sprinklerState = 0;
    }

    public static FanSprinklerState getInstance() {
        return state;
    }

    public boolean isFanOn() {
        return (fanState == 1);
    }

    public boolean isSprinklerOn() {
        return (sprinklerState == 1);
    }

    public void turnFanOn() { fanState = 1; }
    public void turnFanOff() { fanState = 0; }
    public void turnSprinklerOn() { sprinklerState = 1; }
    public void turnSprinklerOff() { sprinklerState = 0; }



}
