package com.raven.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Panel extends JPanel {

    public Panel() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float dist[] = {0f, 1f};
        Color colors[] = {getForeground(), getBackground()};
        RadialGradientPaint gra = new RadialGradientPaint(new Point(getWidth() / 2, 0), getHeight(), dist, colors);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(grphcs);
    }
}
