package camp.characters;

import camp.actions.Action;
import camp.characters.AbstractCharacter;
import camp.needs.Need;

public interface Conductor {
    void addNewConductor(Conductor conductor);
    Action doRequest(Character character, Need need, Request request);
}
