package main;


import model.interfaces.IApplicationState;
import view.interfaces.PaintingBasing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MouseMyClick extends MouseAdapter  {
    private OnPoint startOnPoint;
    private OnPoint endOnPoint;
    private PaintingBasing paintCanvas;
    private ICommand command;
    private IApplicationState appState;

    MouseMyClick(PaintingBasing paintCanvas, IApplicationState appState){
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

            startOnPoint = new OnPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endOnPoint = new OnPoint(e.getX(),e.getY());
        command= new ShapeMyCommand(startOnPoint, endOnPoint,paintCanvas,appState);
        command.run();


    }


}
