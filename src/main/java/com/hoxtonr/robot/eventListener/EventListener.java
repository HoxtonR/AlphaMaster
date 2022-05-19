package com.hoxtonr.robot.eventListener;

import com.hoxtonr.robot.upbitblog.upbitListener;

public class EventListener {
    public static void main(String[] args) {
        upbitListener listener1 = new upbitListener();
        System.out.println(listener1.getBlog());
    }
}
