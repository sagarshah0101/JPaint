package main;

public class redoMyCommand implements ICommand {

    @Override
    public void run() {
        CommandPlay.redo();
    }
}
