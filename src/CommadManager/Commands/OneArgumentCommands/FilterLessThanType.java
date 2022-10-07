package CommadManager.Commands.OneArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;
import Organization.OrganizationType;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FilterLessThanType extends CommandOne<String> {
    @Override
    public String execute(String arg) {
        try {
            OrganizationType.valueOf(arg.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e){ return "Wrong Type";}
        List<Organization> list = CollectionManager.getCollection().stream().filter(p -> p.getType().toString().compareTo(arg.toUpperCase(Locale.ROOT)) < 0).collect(Collectors.toList());
        String response = "";
        for (Organization i : list){
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
