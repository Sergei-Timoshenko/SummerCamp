package characters;

import actions.AbstractAction;
import characters.interfaces.ActionCreator;
import characters.interfaces.Actions;
import characters.interfaces.Conductor;
import characters.needs.RoleNeedName;
import characters.needs.Need;
import characters.needs.NeedName;
import characters.enums.Role;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCharacter implements Conductor, Actions, ActionCreator {
    protected Enum<Role> role;
    protected ArrayList<Need> needs = new ArrayList<>();
    protected ArrayList<Conductor> conductors = new ArrayList<>();
    protected ArrayList<AbstractAction> actions = new ArrayList<>();
    protected AbstractAction currentAction = null;

    public void setNeeds(Role roles) {
        NeedName[] needNames = RoleNeedName.getCharacterNeeds(roles);
        List.of(needNames).forEach(needName -> needs.add(new Need(needName)));
    }
    public void showNeeds() {
        needs.forEach(System.out::println);
    }
    public ArrayList<Need> getNeeds() {
        return needs;
    }

    public abstract void updateNeedValue(Need need);
}
