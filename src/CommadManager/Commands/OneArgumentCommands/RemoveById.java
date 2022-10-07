package CommadManager.Commands.OneArgumentCommands;

import CollectionManager.CollectionManager;

public class RemoveById extends CommandOne<Integer> {
    @Override
    public String execute(Integer id) {
        if (CollectionManager.DelById(id)) {
            return "Removed";
        } else return "No such id";
    }
}
