package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class SettingFrame extends Project2{
    Settings settings = new Settings();
    int x_m,y_m;
    public SettingFrame(int x_m,int y_m){
        this.x_m=x_m;
        this.y_m=y_m;

        JFrame jFrame = new JFrame();

        jFrame.setSize(500,600);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?", "Online Examination System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons,ObjButtons[1]);
                if(PromptResult==0) {
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });

        JCheckBox checkBox = new JCheckBox("Fill circle");
        JLabel label1 = new JLabel("Background color :");
        JLabel label2 = new JLabel("Circles color :");
        JLabel label3 = new JLabel("Timer speed :");

        JTextArea textArea1 = new JTextArea("");
        JTextArea textArea2 = new JTextArea("");
        JTextArea textArea3 = new JTextArea("");

        JLabel label4 = new JLabel("Adding circle   (X=Y=-1  -->  Random)");
        JLabel label5 = new JLabel("Name :");
        JLabel label55 = new JLabel("Name :");
        JLabel label6 = new JLabel("X :");
        JLabel label7 = new JLabel("Y :");
        JLabel label8 = new JLabel("i :");
        JLabel label9 = new JLabel("j :");

        JLabel labela = new JLabel("Changing (x,y empty --> not changing) :");
        JLabel labelb = new JLabel("Name :");
        JLabel labelc = new JLabel("i :");
        JLabel labeld = new JLabel("j :");
        JLabel labele = new JLabel("File :");

        JLabel labelaa = new JLabel("X :");
        JLabel labelbb = new JLabel("Y :");


        JTextField textField1 ,textField2, textField3, textField4,textField5 ,textField6,textField7,textField8 ,textField9,textField10,textFieldaa,textFieldbb;
        textField1= new JTextField();
        textField2= new JTextField();
        textField3= new JTextField();
        textField4= new JTextField();
        textField7= new JTextField();
        textField8= new JTextField();
        textField9= new JTextField();
        textField10= new JTextField();
        textFieldaa= new JTextField();
        textFieldbb= new JTextField();

        JLabel label10 = new JLabel("Removing circle :");
        textField5= new JTextField();
        textField6= new JTextField();

        JButton jButton1 = new JButton("Add");
        JButton jButton2 = new JButton("Remove");
        JButton jButton3 = new JButton("APPLY");
        JButton jButton4 = new JButton("Show All");
        JButton jButton5 = new JButton("Change");


        checkBox.setBounds(10,0,100,40);
        label1.setBounds(190,0,200,40);
        textArea1.setBounds(340,14,150,15);

        label3.setBounds(10,40,100,40);
        textArea3.setBounds(110,54,30,15);
        label2.setBounds(190,40,200,40);
        textArea2.setBounds(340,54,150,15);

        label4.setBounds(10,80,600,40);

        label5.setBounds(10,120,60,40);
        textField1.setBounds(65,132,100,20);
        label6.setBounds(210,120,60,40);
        textField2.setBounds(245,132,70,20);
        label7.setBounds(350,120,60,40);
        textField3.setBounds(385,132,70,20);

        label8.setBounds(215,160,60,40);
        textField4.setBounds(245,172,70,20);
        label9.setBounds(355,160,60,40);
        textField5.setBounds(385,172,70,20);

        jButton1.setBounds(10,210,480,25);

        label10.setBounds(10,240,150,40);


        label55.setBounds(10,270,60,40);
        textField6.setBounds(65,283,100,20);
        jButton2.setBounds(190,280,140,25);
        jButton4.setBounds(350,280,140,25);

        labela.setBounds(10,320,290,40);

        labelb.setBounds(10,350,60,40);
        textField7.setBounds(65,363,100,20);

        labelaa.setBounds(210,350,60,40);
        textFieldaa.setBounds(245,363,70,20);
        labelbb.setBounds(350,350,60,40);
        textFieldbb.setBounds(385,363,70,20);

        labelc.setBounds(215,390,60,40);
        textField8.setBounds(245,403,70,20);
        labeld.setBounds(355,390,60,40);
        textField9.setBounds(385,403,70,20);

        jButton5.setBounds(10,430,480,25);

        labele.setBounds(10,475,60,40);
        textField10.setBounds(65,483,425,25);

        jButton3.setBounds(10,520,480,25);



        textField10.setText(new Setting_loc().get_address());
        checkBox.setSelected(settings.getIs_fill());
        textArea1.setText(settings.getBg_color().getRed()+","+settings.getBg_color().getGreen()+","+settings.getBg_color().getBlue());
        textArea2.setText(settings.getCircle_color().getRed()+","+settings.getCircle_color().getGreen()+","+settings.getCircle_color().getBlue());
        textArea3.setText(settings.getSpeed()+"");


// add
        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x,y;
                Double i,j;
                try {
                    x=Integer.valueOf(textField2.getText());
                    y=Integer.valueOf(textField3.getText());
                    i=Double.valueOf(textField4.getText());
                    j=Double.valueOf(textField5.getText());
                    if ((x>=0 || x==-1)&&(y>=0 || y==-1)&&(textField1.getText()!="")) {
                        Circle circle = new Circle(x, y, i, j);
                        settings.add_circle(textField1.getText(),circle);
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                        JOptionPane.showMessageDialog(null,"Added!","SUCCESS",JOptionPane.INFORMATION_MESSAGE,null);

                    }else {
                        JOptionPane.showMessageDialog(null,"incorrect values","ERROR",JOptionPane.ERROR_MESSAGE,null);
                    }
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"enter two integers for x and y \n two doubles for i and j","ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });

// show all
        jButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String s = settings.get_info();
                JOptionPane.showMessageDialog(null,s,"Circles",JOptionPane.INFORMATION_MESSAGE,null);
            }
        });
// remove
        jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (settings.exist(textField6.getText())){
                    settings.delete(textField6.getText());
                    textField6.setText("");
                    JOptionPane.showMessageDialog(null,"Deleted!","SUCCESS",JOptionPane.INFORMATION_MESSAGE,null);
                }else {
                    JOptionPane.showMessageDialog(null,"Not found!","ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });

// apply
        jButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (textField10.getText() !="" && textArea1.getText() != "" && textArea2.getText()!="" && textArea3.getText()!=""){
                    settings.setFile(textField10.getText());
                    settings.setBg_color(get_color(textArea1.getText()));
                    settings.setCircle_color(get_color(textArea2.getText()));
                    settings.setSpeed(Integer.parseInt(textArea3.getText()));
                    settings.setIs_fill(checkBox.isSelected());
                    Save_Setting sw = new Save_Setting(settings);
                    sw.save();
                    main(new String[0]);
                }
            }
        });

// change
        jButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (settings.exist(textField7.getText())){
                    try{
                        if (textFieldaa.getText().equals("") && textFieldbb.getText().equals("")) {
                            Double i = Double.valueOf(textField8.getText());
                            Double j = Double.valueOf(textField9.getText());
                            settings.change_speed(textField7.getText(), i, j);
                            JOptionPane.showMessageDialog(null, "Changed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, null);
                            textField7.setText("");
                            textField8.setText("");
                            textField9.setText("");
                        }else {
                            int x,y;
                            Double i,j;
                            x=Integer.parseInt(textFieldaa.getText());
                            y=Integer.parseInt(textFieldbb.getText());
                            i = Double.valueOf(textField8.getText());
                            j = Double.valueOf(textField9.getText());
                            settings.change(textField7.getText(),x,y,i,j);
                            JOptionPane.showMessageDialog(null, "Changed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, null);
                            textField7.setText("");
                            textField8.setText("");
                            textField9.setText("");
                            textFieldaa.setText("");
                            textFieldbb.setText("");
                        }
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"incorrect values!","ERROR",JOptionPane.ERROR_MESSAGE,null);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Not found!","ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });


        jFrame.add(checkBox);
        jFrame.add(label1);
        jFrame.add(textArea1);
        jFrame.add(label2);
        jFrame.add(textArea2);
        jFrame.add(label3);
        jFrame.add(textArea3);
        jFrame.add(label5);
        jFrame.add(textField1);
        jFrame.add(label6);
        jFrame.add(textField2);
        jFrame.add(label4);
        jFrame.add(label7);
        jFrame.add(textField3);
        jFrame.add(label8);
        jFrame.add(textField4);
        jFrame.add(label9);
        jFrame.add(textField5);
        jFrame.add(label10);
        jFrame.add(label55);
        jFrame.add(textField6);
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jButton3);
        jFrame.add(jButton4);
        jFrame.add(labela);
        jFrame.add(labelb);
        jFrame.add(labelc);
        jFrame.add(labeld);
        jFrame.add(textField7);
        jFrame.add(textField8);
        jFrame.add(textField9);
        jFrame.add(jButton5);
        jFrame.add(labele);
        jFrame.add(textField10);
        jFrame.add(labelaa);
        jFrame.add(textFieldaa);
        jFrame.add(labelbb);
        jFrame.add(textFieldbb);
        jFrame.setLayout(null);
    }


    public static Color get_color(String s){
        Color c=new Color(192,192,192);
        try {
            int[] t = get_num(s);
            c = new Color(t[0], t[1], t[2]);
        }catch (Exception e){}
        return c;
    }
    public static int[] get_num(String s){
        s+=',';
        int[] num = new int[3];
        String p="";
        int t=0;
        for (int i=0; i<s.length(); i++){
            try {
                p+=Integer.parseInt(s.charAt(i)+"")+"";
            }catch (Exception e){
                if (s.charAt(i)==',') {
                    num[t] = Integer.valueOf(p);
                    p = "";
                    t++;
                }else {
                    Exception E;
                }
            }
            if (t==3)
                break;
        }
        return num;
    }
}