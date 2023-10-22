package characters.interfaces;

import characters.Character;
import characters.needs.Need;

public interface Conductor {
    public void doRequest(Character character, Need need);
}
