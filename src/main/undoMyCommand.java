package main;

public class undoMyCommand implements ICommand{
    @Override
    public void run() {
        CommandPlay.undo();
    }
}
