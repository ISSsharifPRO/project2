package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class CirPo extends JPanel implements ActionListener, Serializable {

    String speed="";
    Settings settings = new Settings();

    Timer timer = new Timer(settings.getSpeed(),this);
    AllCircle allCircle;
    public CirPo(int width, int length){
        allCircle=new AllCircle(width,length);


        if (settings.getCircles().size() != 0) {
            for (Circle c : settings.getCircles()) {
                if (c.getX() == -1 && c.getY() == -1)
                    allCircle.add_circle_rand(c.getJ(), c.getJ());
                if (c.getX() >= 0 && c.getY() >= 0)
                    allCircle.add_circle(c.getX(), c.getY(), c.getI(), c.getJ());
            }
        }

        timer.start();
    }
    public void setbound(int width, int length){
        allCircle.setbound(width,length);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (settings.getIs_fill()) {
            for (Ellipse2D ellipse2D : allCircle.ell_cir()) {
                g.setColor(settings.getCircle_color());
                ((Graphics2D) g).fill(ellipse2D);
            }
        }else {
            for (Ellipse2D ellipse2D : allCircle.ell_cir()) {
                g.setColor(settings.getCircle_color());
                ((Graphics2D) g).draw(ellipse2D);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        allCircle.contact();
        allCircle.cir_con();
        repaint();
    }

    public void pause(int arg0) {
        if (arg0==0)
            timer.stop();
        if (arg0==1)
            timer.start();
    }
}
