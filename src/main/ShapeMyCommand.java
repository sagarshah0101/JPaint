package main;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

public class ShapeMyCommand implements ICommand, IUndoable {
    private OnPoint startOnPoint;
    private OnPoint endOnPoint;
    private PaintingBasing paintCanvas;
    private IApplicationState appState;

    public ShapeMyCommand(OnPoint startOnPoint, OnPoint endOnPoint, PaintingBasing paintCanvas, IApplicationState appState) {
        this.startOnPoint = startOnPoint;
        this.endOnPoint = endOnPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void run() {

        if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
            ItsMyStrategy draw= new drawonsCommandItsMyStrategy(startOnPoint, endOnPoint,paintCanvas,appState);
            draw.executeCommand();
        }






    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}



