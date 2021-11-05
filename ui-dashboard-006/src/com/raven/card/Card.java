package com.raven.card;

import com.raven.shadow.ShadowRenderer;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

public class Card extends javax.swing.JPanel {

    public Color getGradientColor() {
        return gradientColor;
    }

    public void setGradientColor(Color gradientColor) {
        this.gradientColor = gradientColor;
    }

    private Color gradientColor;

    public Card() {
        initComponents();
        setOpaque(false);
        gradientColor = new Color(7, 53, 111);
        setBackground(new Color(0, 79, 181));
    }

    public void setData(ModelCard data) {
        lbTitle.setText(data.getTitle());
        lbValues.setText(data.getValues());
        lbDescription.setText(data.getDescription());
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int shadowSize = 10;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        createShadow(g2, create(0, 0, width, height), shadowSize);
        GradientPaint gra = new GradientPaint(0, 0, getBackground(), 0, height, gradientColor);
        g2.setPaint(gra);
        g2.fill(create(shadowSize, shadowSize, width, height));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private void createShadow(Graphics2D g2, Shape shape, int shadowSize) {
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fill(shape);
        g2.drawImage(new ShadowRenderer(shadowSize, 0.35f, new Color(30, 30, 30)).createShadow(img), 0, 0, null);
    }

    private Shape create(int x, int y, int width, int height) {
        int borrder = 30;
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, borrder, borrder));
        area.add(new Area(new Rectangle2D.Double(x, height - borrder + y, borrder, borrder)));
        area.add(new Area(new Rectangle2D.Double(x + width - borrder, y, borrder, borrder)));
        return area;
    }

    public void setIcon(Icon icon) {
        lbIcon.setIcon(icon);
    }

    public Icon getIcon() {
        return lbIcon.getIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profit.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(190, 190, 190));
        lbTitle.setText("Title");

        lbDescription.setForeground(new java.awt.Color(190, 190, 190));
        lbDescription.setText("Description");
        lbDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        lbValues.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        lbValues.setForeground(new java.awt.Color(190, 190, 190));
        lbValues.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescription)
                            .addComponent(lbValues))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addGap(0, 0, 0)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables
}
