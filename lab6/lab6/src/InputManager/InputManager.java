package InputManager;


import CommadManager.CommandManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*

2. Switch by command name
3. Split line by whitespaces (to ensure number of args)
4. Validate argument
 */
public class InputManager {
    private boolean running = true;
    private final Scanner scanner;
    private final boolean isUser;

    public InputManager(Scanner scanner) {

        this.scanner = scanner;
        this.isUser = false;
    }
    public InputManager() {
        this.isUser = true;
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void run() {
        try {
            if (!isUser) {
                running = scanner.hasNextLine();
            }
            while (running) {
                if (!isUser) {
                    running = scanner.hasNextLine();
                } else {
                    System.out.print("Enter command: ");
                }
                String line = scanner.nextLine().trim();
                processCommand(line);
            }
        } catch (NoSuchElementException e) {
            running = false;
        }
    }

    private void processCommand(String line) {
        String[] lineParts = line.split(" ");
        if (lineParts.length == 0) {
            System.out.println("No such command.");
            return;
        }

        String command = lineParts[0];
        /*
        try {
            String arg1 = lineParts[1];
        } catch (Exception e) {
            String arg1 = "";
        }
        */

        String arg1 = lineParts.length == 2 ? lineParts[1] : "";
        String arg2 = lineParts.length == 3 ? lineParts[2] : "";
        String answer;
        switch (command) {
            case "help":
            case "show":
            case "exit":
            case "info":
            case "history":
            case "clear":
            case "print_field_descending_annual_turnover":
            case "save":{
                if (!validateArgumentsNumber(lineParts.length, 0)) return;
                answer = CommandManager.execute(command);
                break;
            }
            case "add":
            case "add_if_min":
            case "remove_greater":{
                if (!validateArgumentsNumber(lineParts.length, 0)) return;
                InputOrganization org = new InputOrganization(scanner, isUser);
                answer = CommandManager.execute(command, org.run());
                break;
            }
            case "update": {
                if (!validateArgumentsNumber(lineParts.length, 1)) return;
                try {
                    InputOrganization org = new InputOrganization(scanner, isUser);
                    answer = CommandManager.execute(command, Integer.parseInt(lineParts[1]), org.run());
                } catch (NumberFormatException e) {
                    answer = "Wrong id";
                }
                break;
            }
            case "execute_script":
            case "filter_greater_than_postal_address":
            case "filter_less_than_type": {
                if (!validateArgumentsNumber(lineParts.length, 1)) return;
                answer = CommandManager.execute(command, lineParts[1]);
                break;
            }
            case "remove_by_id": {
                if (!validateArgumentsNumber(lineParts.length, 1)) return;
                try {
                    answer = CommandManager.execute(command, Integer.parseInt(lineParts[1]));
                } catch (NumberFormatException e) {
                    answer = "Wrong id";
                }
                break;
            }
            default: {
                answer = "No such command.";
            }
        }
        System.out.println(answer);
    }

    private boolean validateArgumentsNumber(int length, int number) {
        return length == number + 1;
    }

    private <T> boolean validateArgument(T argument, Validator<T> validator) {
        return validator.validate(argument);
    }


    public void stopRunning() {
        running = false;
    }


}
