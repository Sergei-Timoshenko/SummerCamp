package characters.interfaces;

import characters.AbstractCharacter;
import characters.needs.Need;

public interface Conductor {
    public void doRequest(AbstractCharacter character, Need need);
}
