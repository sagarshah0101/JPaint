package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

import java.awt.*;

public class drawonsMyRectangle implements drawonsMyStrategy {
    private PaintingBasing paintCanvas;
    private IApplicationState appState;
    private int x;
    private int y;
    private int width;
    private int height;
    private ShapeColor primary, secondary;
    private ShapeShadingType shading;

    public drawonsMyRectangle(PaintingBasing paintCanvas, IApplicationState appState, int x, int y, int width, int height, ShapeColor primary, ShapeColor secondary, ShapeShadingType shading){
        this.paintCanvas=paintCanvas;
        this.appState=appState;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.primary = primary;
        this.secondary = secondary;
        this.shading=shading;
        if(this.shading.equals(ShapeShadingType.FILLED_IN)) {
            drawFilled();
        }

    }


    @Override
    public void drawFilled() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(ShapeColor.getColor(primary));
        graphics2d.fillRect(x, y, width, height);
    }

}
