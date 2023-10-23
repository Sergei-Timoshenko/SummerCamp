package actions;

import actions.enums.ActionPriority;

import java.util.ArrayList;

public abstract class AbstractAction {
    protected ActionPriority priority;
    protected int ticksToComplete;
    protected int ticksToBegin;

    public void changePriority(ActionPriority priority) {
        this.priority = priority;
    }

    public void update() {
        this.ticksToComplete--;
    }
}
