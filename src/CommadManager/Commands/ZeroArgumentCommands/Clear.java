package CommadManager.Commands.ZeroArgumentCommands;

import CollectionManager.CollectionManager;

public class Clear extends Command{
    @Override
    public String execute() {
        CollectionManager.clearCollection();
        return "Clear!";
    }
}
