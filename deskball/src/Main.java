import sun.plugin.javascript.navig.Image;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
    java.awt.Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.png");
    java.awt.Image desk = Toolkit.getDefaultToolkit().getImage("image/desk.jpg");

    double x = 100;
    double y = 100;
    /*boolean right = true;*//*版本1*/
    double degree = 3.14/3;
    public void paint(Graphics  g){
        System.out.println("窗口被画了一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        if(y>500-40-30||y<40+40){
            degree = -degree;
        }
        if(x<40||x>856-40-30){
            degree = 3.14 - degree;
        }
        /*if(right){
            x = x + 10;
        }else {
            x = x - 10;
        }
        if(x>856-40-30){
            right = false;
        }
        if(x<40){
            right = true;
        }*//*版本1*/
    }

    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);

        while(true){
            repaint();
            try{
                Thread.sleep(40);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("i am the best");
        Main game = new Main();
        game.launchFrame();
    }
}
