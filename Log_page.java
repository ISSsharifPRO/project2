package project2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Log_page implements Serializable {
    public Log_page(){

    }

    public Log_page(Logs logs) {
        JFrame jFrame = new JFrame("Logs");
        jFrame.setSize(500,300);
        jFrame.setLocationRelativeTo(null);

        JList<String> list = new JList<>();
        JScrollPane jScrollPane = new JScrollPane(list);

        String[] s = logs.get_log();
        list.setListData(s);

        jScrollPane.setBounds(10,10,480,200);
        jFrame.add(jScrollPane);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("File :");
        JButton button = new JButton("Save");
        JTextField textField = new JTextField("./RESULT.text");

        label.setBounds(10,215,60,40);
        textField.setBounds(65,225,300,25);
        button.setBounds(390,225,100,25);

        jFrame.add(label);
        jFrame.add(textField);
        jFrame.add(button);


// save button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!textField.getText().equals("")) {
                    File file = new File(textField.getText());
                    try {
                        FileWriter fw = new FileWriter(file);
                        String write="";
                        for (String s1: s){
                            write+=s1+"\n";
                        }
                        fw.write(write);
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Saved!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, null);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,"failed!","ERROR",JOptionPane.ERROR_MESSAGE,null);
                    }
                }
            }
        });
    }
}
