package CommadManager.Commands.OneArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;

public class AddIfMin extends CommandOne<Organization> {
    @Override
    public String execute(Organization arg) {
        if (arg.getAnnualTurnover() < CollectionManager.getMinAnnualTurnover()){
            CollectionManager.addElement(arg);
            return "Added";
        }
        return "Annual Turnover more than the minimum";
    }
}
