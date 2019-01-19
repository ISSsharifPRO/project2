package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project2 extends JFrame{
    int x_m=800, y_m=800;
    CirPo cirPo = new CirPo(x_m,y_m-50);
    Settings settings = new Settings();
    public static void main(String[] args) {
        int x_m=800, y_m=800;
        Project2 l = new Project2();
        l.run(x_m,y_m);
    }

    public void setX_max(int x_m,int y_m) {
        this.x_m = x_m;
    }

    public void run(int x_m, int y_m){
        JFrame jFrame = new JFrame();
        jFrame.setBounds(0,0,x_m,y_m);
        jFrame.setTitle("Dramatist");


        cirPo.setBounds(0,52,800,750);
        cirPo.setBackground(settings.getBg_color());
        jFrame.add(cirPo);

        jFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                cirPo.setbound(e.getComponent().getWidth(),e.getComponent().getHeight()-52);
                setX_max(e.getComponent().getWidth(),e.getComponent().getHeight());
                cirPo.setBounds(0,52,e.getComponent().getWidth(),e.getComponent().getHeight()-52);
            }
        });



        Color c = new Color(100,100,100);
//play button
        JButton jb1 = new JButton("play");
        JButton jb2 = new JButton("pause");
        jb1.setBounds(0,0,100,50);
        jFrame.add(jb1);
        jb1.setBackground(new Color(40,40,40));
        jb1.setForeground(c);
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!cirPo.timer.isRunning()){
                    cirPo.pause(1);
                    jb2.setForeground(Color.white);
                    jb1.setForeground(c);
                }
            }
        });




//pause button
        jb2.setBounds(101,0,100,50);
        jFrame.add(jb2);
        jb2.setBackground(new Color(50,50,50));
        jb2.setForeground(Color.white);
        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (cirPo.timer.isRunning()) {
                    cirPo.pause(0);
                    jb2.setForeground(c);
                    jb1.setForeground(Color.white);
                }
            }
        });


//setting button
        JButton jb = new JButton("setting");
        jb.setBackground(new Color(50,50,50));
        jb.setForeground(Color.white);
        jb.setVisible(true);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cirPo.pause(0);
                SettingFrame settingFrame = new SettingFrame(x_m,y_m);
                jb2.setForeground(c);
                jb1.setForeground(Color.white);
            }
        });
        jb.setBounds(202,0,150,50);
        jFrame.add(jb);



        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    public void start(int i){
        cirPo.pause(i);
    }
}