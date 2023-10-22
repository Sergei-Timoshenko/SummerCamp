package characters;

import actions.AbstractAction;
import actions.Eating;
import actions.Playing;
import actions.enums.ActionPriority;
import characters.enums.TickCode;
import characters.interfaces.Actions;
import characters.needs.Need;
import characters.enums.Role;
import timeline.enums.HourCode;

import javax.swing.*;

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
    public void doRequest(AbstractCharacter character, Need need) {

    }

    @Override
    public void addNewAction(AbstractAction abstractAction) {

    }

    @Override
    public void doAction(int currentTick) {
        TickCode tickCode = TickCode.getSchedule(currentTick);
        if (tickCode == TickCode.BREAKFAST_PREPARATION || tickCode == TickCode.LUNCH_PREPARATION || tickCode == TickCode.DINNER_PREPARATION) {
            actions.add(new Eating(ActionPriority.NORMAL, 25, 30));
        } else {
            actions.add(new Playing(ActionPriority.NORMAL, 15, 0));
        }
    }
}
