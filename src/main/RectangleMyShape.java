package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;


import java.awt.*;

 class RectangleShape extends Shape {

    private int newWidth;
     private int newHeight;
    private OnPoint selectOnPoint;
     private int x;
     private int y;
     private int iD=-10;
     private Boolean isMoved;
     private drawonsMyStrategy drawRect;
     private ShapeShadingType shading;
     private ShapeColor primary,secondary;


     public RectangleShape(OnPoint startOnPoint, OnPoint endOnPoint, PaintingBasing paintCanvas, IApplicationState appState) {
         this.startOnPoint = startOnPoint;
         this.endOnPoint = endOnPoint;
         this.paintCanvas = paintCanvas;
         this.appState = appState;
         newWidth= Math.abs(endOnPoint.getX() - startOnPoint.getX());
         newHeight=Math.abs(endOnPoint.getY() - startOnPoint.getY());
         selectOnPoint =new OnPoint(Math.min(startOnPoint.getX(), endOnPoint.getX()),Math.min(startOnPoint.getY(), endOnPoint.getY()));
         x= selectOnPoint.getX();
         y= selectOnPoint.getY();
         this.primary = appState.getActivePrimaryColor();
         this.secondary = appState.getActiveSecondaryColor();
         this.shading=appState.getActiveShapeShadingType();
     }

     public void drawShape() {
         drawRect = new drawonsMyRectangle(paintCanvas, appState, getX(), getY(), getNewWidth(), getNewHeight(),primary,secondary,shading);


     }




     @Override
     public void setColor(ShapeColor primary, ShapeColor secondary) {
         this.primary=primary;
         this.secondary=secondary;
     }

     @Override
     public ShapeColor getPrimaryColor() {
         return primary;
     }

     @Override
     public ShapeColor getSecondaryColor() {
         return secondary;
     }

     public Boolean getMoved(){return isMoved;}

     public void setMoved(Boolean answ){
         isMoved=answ;
     }

     @Override
     public Boolean isPolygon() {
         return false;
     }

     @Override
     public Boolean isRectangle() {
         return true;
     }

     @Override
     public Boolean isEllipse() {
         return false;
     }

     @Override
     public void setGroupID(int id) {
         iD=id;
     }

     @Override
     public int groupID() {
         return iD;
     }

     @Override
     public void setSelected(Boolean answ) {
         isSelected=answ;

     }

     @Override
     public Boolean IsSelected() {
         return isSelected;
     }

     @Override
     public void setShading(ShapeShadingType shade) {
         shading=shade;
     }

     @Override
     public ShapeShadingType getShading() {
         return shading;
     }

     @Override
     public OnPoint getStartPoint() {
         return startOnPoint;
     }



     @Override
     public OnPoint getEndPoint() {
                return endOnPoint;
     }



     @Override
     public void clearShape() {

           Graphics2D graphics2d = paintCanvas.getGraphics2D();
          graphics2d.setColor(Color.WHITE);
          graphics2d.fillRect(getX()-10, getY()-10,getNewWidth()+20,getNewHeight()+20);
     }

     @Override
     public void setX(int point) {
         x = point;
     }

     @Override
     public void setY(int point) {
       y=point;
     }




     public void selectShape() {

         Graphics2D graphics2d = paintCanvas.getGraphics2D();
         Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
         graphics2d.setStroke(stroke);
         graphics2d.setColor(Color.BLACK);
         graphics2d.drawRect(getX()-5, getY()-5, getNewWidth()+10, getNewHeight()+10);
     }


     public int getNewWidth() {
         return newWidth;
     }

     public int getNewHeight() {
         return newHeight;
     }

     public int getX() {
         return x;
     }

     public int getY() {
         return y;
     }

     @Override
     public int getX1() {
         return 0;
     }

     @Override
     public int getY1() {
         return 0;
     }





 }
