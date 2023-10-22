package characters;

import actions.Action;
import characters.needs.Need;
import characters.roles.Roles;

public class Child extends Character {
    public Child(Roles role) {
        this.role = role;

        this.setNeeds(role);
    }

    @Override
    public void updateNeedValue(Need need) {
        need.setValue(10);
    }

    @Override
    public void doRequest(Character character, Need need) {

    }

    @Override
    public void addNewAction(Action action) {

    }

    @Override
    public int doAction() {
        return 0;
    }
}
