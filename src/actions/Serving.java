package actions;

import actions.enums.ActionPriority;

public class Serving extends AbstractAction {
    public Serving(ActionPriority priority, int ticksToComplete, int ticksToBegin) {
        this.priority = priority;
        this.ticksToComplete = ticksToComplete;
        this.ticksToBegin = ticksToBegin;
    }
}
