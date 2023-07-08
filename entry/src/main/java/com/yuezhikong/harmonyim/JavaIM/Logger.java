package com.yuezhikong.harmonyim.JavaIM;

import org.yuezhikong.JavaIMAndroid.MainActivity;

public class Logger {
    public void info(String Message) {
        MainActivity.getInstance().OutputToChatLog(Message);
    }
}
