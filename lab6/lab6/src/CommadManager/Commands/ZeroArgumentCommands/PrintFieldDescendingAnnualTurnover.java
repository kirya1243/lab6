package CommadManager.Commands.ZeroArgumentCommands;

import CollectionManager.CollectionManager;

public class PrintFieldDescendingAnnualTurnover extends Command{
    @Override
    public String execute() {
        for(Integer i: CollectionManager.getAnnualsTurnovers()){
            System.out.println(i);
        }
        return "Done";
    }
}
