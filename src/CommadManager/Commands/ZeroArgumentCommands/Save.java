package CommadManager.Commands.ZeroArgumentCommands;

import CollectionManager.CollectionManager;
import Organization.Organization;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Save extends Command{
    @Override
    public String execute() {
        JSONArray list = new JSONArray();
        for (Organization i : CollectionManager.getCollection()){
            JSONObject obj = new JSONObject();
            obj.put("id",  i.getId());
            obj.put("name", i.getName());
            obj.put("coordinate X",  i.getCoordinates().getX());
            obj.put("coordinate Y",  i.getCoordinates().getY());
            obj.put("creation date", i.getCreationDate().toString());
            obj.put("annual turnover", i.getAnnualTurnover());
            obj.put("type", i.getType().toString());
            obj.put("address", i.getPostalAddress().getStreet());
            list.add(obj);
        }
        String jsonString = JSONValue.toJSONString(list);
        PrintWriter writer1 =null;
        try {
            writer1 = new PrintWriter(new File("src/Collection.json"));
            writer1.print(jsonString);
            writer1.flush();
            writer1.close();
        } catch (FileNotFoundException e){
            return "File not found";
        }
        return "";
    }
}
