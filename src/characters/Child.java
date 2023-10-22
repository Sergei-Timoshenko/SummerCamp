package characters;

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
}
