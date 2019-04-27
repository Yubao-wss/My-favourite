package com.wss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;


import static javafx.scene.input.KeyCode.T;

/**
 * @Author: WSS
 * @Date: 2019/4/24 13:07
 * @Description:
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        Timer t = new Timer(500,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is "+ System.currentTimeMillis());
        Toolkit.getDefaultToolkit().beep();
    }
}
