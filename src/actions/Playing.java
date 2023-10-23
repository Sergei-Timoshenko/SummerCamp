package actions;

import actions.enums.ActionPriority;

public class Playing extends AbstractAction{
    public Playing(ActionPriority priority, int ticksToComplete, int ticksToBegin) {
        this.priority = priority;
        this.ticksToComplete = ticksToComplete;
        this.ticksToBegin = ticksToBegin;
    }
}
