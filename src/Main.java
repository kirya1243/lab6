import CollectionManager.CollectionManager;
import InputManager.InputManager;
import com.sun.security.ntlm.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        try {
            String filename = args[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Missing argument, program exit");
            System.exit(0);
        }
        CollectionManager.setFileName(args[0]);
        try {
            new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println("No such file, program exit");
            System.exit(0);
        }
        CollectionManager.loadCollection();
        inputManager.run();

    }
}
