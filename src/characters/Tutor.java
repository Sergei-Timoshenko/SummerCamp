package characters;

import actions.AbstractAction;
import characters.enums.Role;
import characters.needs.Need;
import timeline.enums.HourCode;

public class Tutor extends AbstractCharacter {
    public Tutor(Role role) {
        this.role = role;
    }

    @Override
    public void updateNeedValue(Need need) {

    }

    @Override
    public void addNewAction(AbstractAction abstractAction) {

    }

    @Override
    public int doAction(HourCode hourStatus) {
        return 0;
    }

    @Override
    public void doRequest(Character character, Need need) {

    }
}
