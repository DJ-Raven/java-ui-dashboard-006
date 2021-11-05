package com.raven.chart.blankchart;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class BlankPlotChatRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);

    public abstract boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index);
}
