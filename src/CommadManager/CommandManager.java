package CommadManager;

import CommadManager.Commands.OneArgumentCommands.*;
import CommadManager.Commands.ZeroArgumentCommands.*;
import CommadManager.Commands.OneArgumentCommands.*;
import CommadManager.Commands.TwoArgumentsCommands.Update;
import CommadManager.Commands.ZeroArgumentCommands.*;
import Organization.Organization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {
    private static final HistoryManager historyManager = new HistoryManager();
    private static final List<String> commands = Arrays.asList("help", "show", "exit", "info", "history", "add", "clear",
            "print_field_descending_annual_turnover", "save", "execute_script", "remove_by_id", "add_if_min", "remove_greater",
            "filter_greater_than_postal_address", "filter_less_than_type", "update");
    public static String execute(String command){
        if (commands.contains(command)) historyManager.setHistoryList(command);
        switch (command){
            case "help": {
                return new Help().execute();
            }
            case "show": {
                return new Show().execute();
            }
            case "exit": {
                return new Exit().execute();
            }
            case "info": {
                return new Info().execute();
            }
            case "history": {
                return new History(historyManager.getHistoryList()).execute();
            }
            case "clear": {
                return new Clear().execute();
            }
            case "print_field_descending_annual_turnover": {
                return new PrintFieldDescendingAnnualTurnover().execute();
            }
            case "save": {
                return new Save().execute();
            }
            default:{
                return "No such command.";
            }
        }
    }
    public static <T> String execute(String command, T arg){
        if (commands.contains(command)) historyManager.setHistoryList(command);
        switch (command){
            case "add": {
                return new Add().execute((Organization) arg);
            }
            case "execute_script": {
                return new ExecuteScript().execute((String) arg);
            }
            case "remove_by_id": {
                return new RemoveById().execute((Integer) arg);
            }
            case "add_if_min": {
                return new AddIfMin().execute((Organization) arg);
            }
            case "remove_greater": {
                return new RemoveGreater().execute((Organization) arg);
            }
            case "filter_greater_than_postal_address": {
                return new FilterGreaterThanPostalAddress().execute((String) arg);
            }
            case "filter_less_than_type": {
                return new FilterLessThanType().execute((String) arg);
            }
            default:{
                return "No such command.";
            }
        }
    }
    public static <T> String execute(String command, Integer id, Organization arg){
        if (commands.contains(command)) historyManager.setHistoryList(command);
        switch (command){
            case "update": {
                return new Update().execute(id, arg);
            }
            default:{
                return "No such command.";
            }
        }
    }
    private static class HistoryManager {
        private ArrayList<String> historyList = new ArrayList<>();
        private int histLength = 6;

        public ArrayList<String> getHistoryList() {
            return historyList;
        }

        public void setHistoryList(String historyElem) {
            historyList.add(historyElem);
            if (historyList.size() > histLength) {
                historyList.remove(0);
            }
        }
    }

}
