package CommadManager.Commands.OneArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;

public class Add extends CommandOne<Organization> {

    @Override
    public String execute(Organization arg) {
        CollectionManager.addElement(arg);
        return "Added";
    }
}