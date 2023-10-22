package characters;

import characters.roles.Roles;

public class Child extends Character {
    public Child(Roles role) {
        this.role = role;

        this.setNeeds(role);
    }


}
