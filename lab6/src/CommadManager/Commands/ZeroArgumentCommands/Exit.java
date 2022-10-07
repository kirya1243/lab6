package CommadManager.Commands.ZeroArgumentCommands;

import InputManager.InputManager;

public class Exit extends Command{
    InputManager inputManager;
    void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public String execute() {
        System.out.println("Bye bye!");
        System.exit(0);
        return "";
    }
}
