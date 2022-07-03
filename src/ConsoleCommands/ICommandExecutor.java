package ConsoleCommands;

public interface ICommandExecutor {
    int execute(String command);
    CommandList getCommand();
}
