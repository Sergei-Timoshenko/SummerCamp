package actions;

import actions.AbstractAction;
import actions.enums.ActionPriority;

public class Cooking extends AbstractAction {
    public Cooking(ActionPriority priority, int ticksToComplete, int ticksToBegin) {
        this.priority = priority;
        this.ticksToComplete = ticksToComplete;
        this.ticksToBegin = ticksToBegin;
    }
}
