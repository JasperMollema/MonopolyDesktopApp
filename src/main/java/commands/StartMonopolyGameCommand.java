package commands;

public class StartMonopolyGameCommand extends AbstractCommand{

    @Override
    public void execute() {
        System.out.println("Execute Start Monopoly Game Command");
        getMainController().showSelectNumberOfPlayersView();
        System.out.println("Start a MonopolyGame");
    }
}
