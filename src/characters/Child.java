package characters;

import actions.AbstractAction;
import characters.needs.Need;
import characters.enums.Role;
import timeline.enums.HourCode;

public class Child extends AbstractCharacter {
    public Child(Role roles) {
        this.role = roles;

        this.setNeeds(roles);
    }

    @Override
    public void updateNeedValue(Need need) {
        need.setValue(10);
    }

    @Override
    public void doRequest(Character character, Need need) {

    }

    @Override
    public void addNewAction(AbstractAction abstractAction) {

    }

    @Override
    public int doAction(HourCode hourStatus) {
        return 0;
    }
}
