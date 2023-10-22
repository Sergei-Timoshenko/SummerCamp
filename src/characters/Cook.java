package characters;

import actions.AbstractAction;
import characters.enums.Role;
import characters.needs.Need;

public class Cook extends AbstractCharacter {
    public Cook(Role role) {
        this.role = role;
    }

    @Override
    public void updateNeedValue(Need need) {

    }

    @Override
    public void addNewAction(AbstractAction abstractAction) {

    }

    @Override
    public void doAction(int currentTick) {

    }

    @Override
    public void doRequest(AbstractCharacter character, Need need) {

    }
}
