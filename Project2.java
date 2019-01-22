package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class Project2 extends JFrame implements Serializable {

    int x_m=800, y_m=800;
    CirPo cirPo = new CirPo(x_m,y_m-50);
    private Logs logs = AllCircle.logs;
    private Long time=0l;


    public Project2(){}

    //Settings settings = new Settings();

    public static void main(String[] args) {
        int x_m=800, y_m=800;
        Project2 l = new Project2();
        l.run(x_m,y_m,new Settings());
    }

    public void setX_max(int x_m,int y_m) {
        this.x_m = x_m;
    }

    public void run(int x_m, int y_m,Settings settings){
        JFrame jFrame = new JFrame();
        jFrame.setBounds(0,0,x_m,y_m);
        jFrame.setTitle("Dramatist");
        cirPo.setBounds(0,52,800,750);
        cirPo.setBackground(settings.getBg_color());
        jFrame.add(cirPo);
        JButton log = new JButton("Log");
        log.setBounds(353,0,80,50);
        log.setBackground(new Color(40,40,40));
        log.setForeground(Color.white);
        jFrame.add(log);

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
                    // new time
                    logs.l=System.currentTimeMillis();
                    logs.x=time;
                    System.out.println(time);
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
                    time=logs.y;
                }
            }
        });


//setting button
        JButton jb = new JButton("setting");
        jb.setBackground(new Color(50,50,50));
        jb.setBorderPainted(true);
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
                time=logs.y;
            }
        });
        jb.setBounds(202,0,150,50);
        jFrame.add(jb);


// save button
        JButton save = new JButton("save in file");
        save.setBackground(new Color(50,50,50));
        save.setBorderPainted(true);
        save.setForeground(Color.white);
        save.setVisible(true);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                time=logs.y;
                cirPo.pause(0);
                jb2.setForeground(c);
                jb1.setForeground(Color.white);
               // System.out.println(cirPo.getAllCircle().get_circle().get(0).getX());
                Settings settings2 = settings;
                settings2.new_circle(cirPo.getAllCircle());
                try {
                    String location = JOptionPane.showInputDialog("enter file address :");
                    new Save_Setting(settings2,location);
                }catch (Exception e1){}
            }
        });
        save.setBounds(434,0,150,50);
        jFrame.add(save);


// open button
        JButton open = new JButton("open from file");
        open.setBackground(new Color(50,50,50));
        open.setBorderPainted(true);
        open.setForeground(Color.white);
        open.setVisible(true);
        open.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                time=logs.y;
                cirPo.pause(0);
                jb2.setForeground(c);
                jb1.setForeground(Color.white);
                try {
                    String location = JOptionPane.showInputDialog("enter file address :");
                    Settings newsettings = new Save_Setting().read(location);
                    cirPo = new CirPo(x_m, y_m, newsettings);
                    run(x_m, y_m, newsettings);
                }catch (Exception er){}
            }
        });
        open.setBounds(585,0,150,50);
        jFrame.add(open);


/*
// time button
        JButton time2 = new JButton("time");
        time2.setBackground(new Color(50,50,50));
        time2.setBorderPainted(true);
        time2.setForeground(Color.white);
        time2.setVisible(true);
        time2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                time2.setText(logs.l+"");
                System.out.println(55);
            }
        });
        time2.setBounds(735,0,300,50);
        jFrame.add(time2);

        */


// log button
        log.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cirPo.pause(0);
                time=logs.y;
                jb2.setForeground(c);
                jb1.setForeground(Color.white);
                new Log_page(logs);
            }
        });

        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}