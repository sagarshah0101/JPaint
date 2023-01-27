package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

public class drawonsCommandItsMyStrategy implements ItsMyStrategy {

    private OnPoint startOnPoint;
    private OnPoint endOnPoint;
    private PaintingBasing paintCanvas;
    private IApplicationState appState;
    private ICommand draw;
    public drawonsCommandItsMyStrategy(OnPoint startOnPoint, OnPoint endOnPoint, PaintingBasing paintCanvas, IApplicationState appState) {
        this.startOnPoint = startOnPoint;
        this.endOnPoint = endOnPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
        draw= new drawonsStartOneCommand(startOnPoint, endOnPoint,paintCanvas,appState);
        draw.run();
    }
}
