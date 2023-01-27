package main;

//import extras.EllipseShape;
//import extras.TriangleShape;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

class getShapeMyFactory {
    private OnPoint startOnPoint;
    private OnPoint endOnPoint;
    private PaintingBasing paintCanvas;
    private IApplicationState appState;


    public void getShape(IApplicationState appState, OnPoint startOnPoint, OnPoint endOnPoint, PaintingBasing paintCanvas) {
        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
            Shape shep = new RectangleShape(startOnPoint, endOnPoint, paintCanvas, appState);
            shep.drawShape();
            appState.setShapelist(shep);

        }


    }

}
