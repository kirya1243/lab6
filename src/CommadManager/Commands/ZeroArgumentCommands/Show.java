package CommadManager.Commands.ZeroArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;

public class Show extends Command{

    @Override
    public String execute() {
        String response = "";
        for (Organization i : CollectionManager.getCollection()){
            response+="id: " + i.getId()+"\n";
            response+="name: " + i.getName()+"\n";
            response+="coordinate X: " + i.getCoordinates().getX()+"\n";
            response+="coordinate Y: " + i.getCoordinates().getY()+"\n";
            response+="creation date: " + i.getCreationDate()+"\n";
            response+="annual turnover: " + i.getAnnualTurnover()+"\n";
            response+="type: " + i.getType()+"\n";
            response+="address: " + i.getPostalAddress().getStreet()+"\n";
        }
        if (response.length() > 0) {
            return response.substring(0, response.length() - 1);
        } else return "Empty";
    }
}
