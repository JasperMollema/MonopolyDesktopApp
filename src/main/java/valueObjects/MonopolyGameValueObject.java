package valueObjects;

import java.util.List;
import java.util.Map;

public class MonopolyGameValueObject {
    public List<BoardSpaceValueObject> boardSpaces;
    public Map<String, Integer> playerPositions;
    public String activePlayer;
    public String diceThrow1;
    public String diceThrow2;
    public Boolean canThrowAgain;
}
