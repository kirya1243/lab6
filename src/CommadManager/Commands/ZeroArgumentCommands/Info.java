package CommadManager.Commands.ZeroArgumentCommands;

import CollectionManager.CollectionManager;

import java.io.File;
import java.util.Date;

public class Info extends Command{
    @Override
    public String execute() {
        Date fileDate = new Date(new File(CollectionManager.getFileName()).lastModified());
        return "Type: " + CollectionManager.getCollection().getClass()+"\n"+
                "Initialization date: " + fileDate +"\n" +
                "Number of elements: " + CollectionManager.getCollection().size();
    }
}
