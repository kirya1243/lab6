package CommadManager.Commands.TwoArgumentsCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;

public class Update extends CommandTwo <Integer, Organization>{
    @Override
    public String execute(Integer id, Organization arg) {
        if (CollectionManager.DelById(id)) {
            arg.setId(id);
            CollectionManager.addElement(arg);
            return "Updated";
        } else return "No such id";
    }
}
