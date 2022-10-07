package CommadManager.Commands.OneArgumentCommands;


import InputManager.InputManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExecuteScript extends CommandOne<String> {

    static List<String> scripts = new ArrayList<>();

    @Override
    public String execute(String arg) {
        String answer = "Script " + arg + " completed";
        try {
            if (scripts.contains(arg)) {
                answer = "The script is already running";
            } else {
                scripts.add(arg);
                new InputManager(new Scanner(new FileReader(arg))).run();
                scripts.remove(arg);
            }
        } catch (FileNotFoundException e) {
            answer = "File not found";
        }

        return answer;
    }
}
