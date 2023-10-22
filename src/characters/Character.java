package characters;

import characters.roles.RoleNeeds;
import characters.needs.Need;
import characters.needs.NeedType;
import characters.roles.Roles;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected Enum<Roles> role;

    protected ArrayList<Need> needs = new ArrayList<>();

    public void setNeeds(Roles role) {
        NeedType[] needTypes = RoleNeeds.getCharacterNeeds(role);
        List.of(needTypes).forEach(needType -> needs.add(new Need(needType)));
    }
    public void showNeeds() {
        needs.forEach(System.out::println);
    }
    public ArrayList<Need> getNeeds() {
        return needs;
    }

    public abstract void updateNeedValue(Need need);
}
