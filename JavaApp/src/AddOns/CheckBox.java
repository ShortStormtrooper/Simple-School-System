/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddOns;

/**
 *
 * @author Samardzija Njegos
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JCheckBox;

/**
 *
 * @author Samardzija Njegos
 */
public class CheckBox extends JCheckBox {

    private final int border = 4;

    public CheckBox() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 255));

    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ly = (getHeight() - 16) / 2;
        if (isSelected()) {
            if (isEnabled()) {
                g2.setColor(getBackground());
            } else {
                g2.setColor(getBackground());
            }
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            //  Draw Check icon
            int px[] = {4, 8, 14, 12, 8, 6};
            int py[] = {ly + 8, ly + 14, ly + 5, ly + 3, ly + 10, ly + 6};
            g2.setColor(Color.WHITE);
            g2.fillPolygon(px, py, px.length);
        } else {
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(1, ly, 16, 16, border, border);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(2, ly + 1, 14, 14, border, border);
        }
        g2.dispose();
    }
}
