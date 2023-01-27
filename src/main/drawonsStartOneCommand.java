package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

import java.util.ArrayList;

public class drawonsStartOneCommand implements ICommand, IUndoable {
    private OnPoint startOnPoint;
    private OnPoint endOnPoint;
    private PaintingBasing paintCanvas;
    private IApplicationState appState;
    ArrayList<Shape> redo= new ArrayList<Shape>();

    public drawonsStartOneCommand(OnPoint startOnPoint, OnPoint endOnPoint, PaintingBasing paintCanvas, IApplicationState appState){
        this.startOnPoint = startOnPoint;
        this.endOnPoint = endOnPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;

    }
    @Override
    public void run() {
        CommandPlay.add(this);
        getShapeMyFactory get = new getShapeMyFactory();
        get.getShape(appState, startOnPoint, endOnPoint, paintCanvas);
    }

    @Override
    public void undo() {
        System.out.println("drawCommand");
        appState.getShapelist();
        for(int i=appState.getShapelist().size()-1;i>=0;i--){
            appState.getShapelist().get(i).clearShape();
            redo.add(appState.getShapelist().get(i));
            appState.getShapelist().remove(appState.getShapelist().get(i));
            break;

        }





    }


    @Override
    public void redo() {

       for(Shape s: redo){
           s.drawShape();
           redo.remove(s);
           appState.getShapelist().add(s);
        }


    }
}
