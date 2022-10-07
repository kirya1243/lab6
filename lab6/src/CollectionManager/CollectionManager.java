package CollectionManager;


import Organization.Address;
import Organization.Coordinates;
import Organization.Organization;
import Organization.OrganizationType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

public class CollectionManager {
    private static LinkedHashSet<Organization> collection = new LinkedHashSet<>();
    private static String fileName;
    private static Integer minAnnualTurnover = Integer.MAX_VALUE;
    public static ArrayList<Integer> annualList = new ArrayList<>();
    public static void addElement(Organization org){
        collection.add(org);
    }
//    public static void addElementById(Integer id, Organization org){
//        collection.
//    }
//    public static void removeElementById(Integer id, Organization org){
//        collection.
//    }
    public static void clearCollection(){
        collection.clear();
    }

    public static LinkedHashSet<Organization> getCollection() {
        return collection;
    }

    public static void loadCollection() {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            Object obj = JSONValue.parse(scanner.nextLine());
            JSONArray array = (JSONArray)obj;
            for (Object i: array) {
                JSONObject object = (JSONObject) i;
                Organization organization = new Organization();
//                String[] elem = scanner.nextLine().split(", "); //ORG json parser
                organization.setId(Integer.parseInt(object.get("id").toString()));
                organization.setName((String) object.get("name"));
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Double.parseDouble(object.get("coordinate X").toString()));
                coordinates.setY(Double.parseDouble(object.get("coordinate Y").toString()));
                organization.setCoordinates(coordinates);
                organization.setCreationDate(LocalDate.parse((String) object.get("creation date")));
                organization.setAnnualTurnover(Integer.parseInt(object.get("annual turnover").toString()));
                organization.setType(OrganizationType.valueOf(((String) object.get("type")).toUpperCase(Locale.ROOT)));
                Address address = new Address();
                address.setStreet((String) object.get("address"));
                organization.setPostalAddress(address);
                collection.add(organization);
            }
            System.out.println("Collections added");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void setFileName(String fileName) {
        CollectionManager.fileName = fileName;
    }

    public static String getFileName() {
        return fileName;
    }

    public static boolean DelById(Integer id) {
        for (Organization i : collection) {
            if (Objects.equals(i.getId(), id)){
                collection.remove(i);
                return true;
            }
        }
        return false;
    }
    public static Integer getMinAnnualTurnover(){
        for (Organization i : collection) {
            minAnnualTurnover = Math.min(i.getAnnualTurnover(), minAnnualTurnover);
        }
        return minAnnualTurnover;
    }
    public static void removeGreater(Integer annualTurnover){
        for (Organization i : collection) {
            if (i.getAnnualTurnover() > annualTurnover){
                collection.remove(i);
            }
        }
    }
    public static ArrayList<Integer> getAnnualsTurnovers(){
        annualList.clear();
        for (Organization i: collection) {
            annualList.add(i.getAnnualTurnover());
        }
        annualList.sort(Collections.reverseOrder());
        return annualList;
    }
}
