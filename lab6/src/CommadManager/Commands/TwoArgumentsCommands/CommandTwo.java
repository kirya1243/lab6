package CommadManager.Commands.TwoArgumentsCommands;

public abstract class CommandTwo <T, U>{
    public abstract String execute(T id, U arg);
}
