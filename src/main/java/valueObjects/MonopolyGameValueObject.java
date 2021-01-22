package valueObjects;

import java.util.List;
import java.util.Map;

public class MonopolyGameValueObject {
    public List<BoardSpaceValueObject> boardSpaces;
    public Map<String, Integer> playerPositions;
    public String statusMessage;
    public String[] statusMessageArgs;
    public String activePlayer;
}
