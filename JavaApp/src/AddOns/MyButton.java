/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddOns;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author Samardzija Njegos
 */
public class MyButton extends JButton {

    public MyButton() {
        //  Init Color
        setBackground(new Color(0, 0, 0, 220));
        borderColor = new Color(255, 255, 255, 255);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    private Color borderColor;
    private int radius = 15;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        //g2.setColor(getBackground());
        //  Border set 2 Pix
        //g2.fillRoundRect(0, 0, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
