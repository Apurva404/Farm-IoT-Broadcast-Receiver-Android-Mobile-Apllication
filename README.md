# Farm-IoT-Broadcast-Receiver-Android-Mobile-Application
This app demonstrates how to apply broadcast receiver mechanism to send and receive data between activities.
The app takes temperature and humidity from the user and automates the process of switching on fan and sprinkler accordingly. 
Few important features of the application are:
1. MainActivity.java(landing screen) is the receiver, listening for user input,
2. TempHumidityDataGatherer.java takes temperature and humidity from user and broadcasts it.
3. Proper handling of visibility of buttons and textviews in FanSprinklerStateViewer.java
4. Proper error handling.
