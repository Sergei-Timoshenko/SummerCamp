package actions;

import actions.enums.ActionPriority;

import java.util.ArrayList;

public abstract class AbstractAction {
    protected long startTime; // TODO: Time type
    protected Enum<ActionPriority> priority;
    protected int minTickDuration;
    protected int maxTickDuration;
    protected int minTickPlanning;
    protected int maxTickPlanning;
    protected int range; // TODO: Ask Oleksandr about it's purpose
    protected ArrayList<AbstractAction> dependentAbstractActions = new ArrayList<>();

    public abstract void update(long time); // TODO: Time type
}
