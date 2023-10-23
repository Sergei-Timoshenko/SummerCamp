package actions;

import actions.enums.ActionPriority;

public class Eating extends AbstractAction{
    public Eating(ActionPriority priority, int ticksToComplete, int ticksToBegin) {
        this.priority = priority;
        this.ticksToComplete = ticksToComplete;
        this.ticksToBegin = ticksToBegin;
    }
}
