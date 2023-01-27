package view.gui;

import view.interfaces.PaintingBasing;

import java.awt.*;

public class PaintCanvas extends PaintingBasing {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
