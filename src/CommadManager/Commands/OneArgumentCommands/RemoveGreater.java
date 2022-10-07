package CommadManager.Commands.OneArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;

public class RemoveGreater extends CommandOne<Organization> {
    @Override
    public String execute(Organization arg) {
        CollectionManager.removeGreater(arg.getAnnualTurnover());
        return "Done";
    }
}
