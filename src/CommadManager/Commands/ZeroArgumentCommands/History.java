package CommadManager.Commands.ZeroArgumentCommands;


import java.util.ArrayList;

public class History extends Command{
    private final ArrayList<String> history;
    public History(ArrayList<String> history) {
        this.history = history;
    }

    @Override
    public String execute() {
        return history.toString();
    }
}
