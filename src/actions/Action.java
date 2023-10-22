package actions;

import java.util.ArrayList;

public abstract class Action {
    protected long startTime; // TODO: Time type
    protected Enum<ActionPriority> priority;
    protected int minTickDuration;
    protected int maxTickDuration;
    protected int minTickPlanning;
    protected int maxTickPlanning;
    protected int range; // TODO: Ask Oleksandr about it's purpose
    protected ArrayList<Action> dependentActions = new ArrayList<>();

    public abstract void update(long time); // TODO: Time type
}
