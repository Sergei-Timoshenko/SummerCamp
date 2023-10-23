package camp.characters;

import camp.needs.Need;
import camp.actions.Action;

import java.util.ArrayList;
import java.util.HashSet;

public class AbstractCharacter implements Character, Conductor {
    private String name;
    private HashSet<Need> needs = new HashSet<>();
    private Action currentAction = null;
    private ArrayList<Action> actions = new ArrayList<>();
    private HashSet<Conductor> conductors = new HashSet<>();

    public AbstractCharacter(String name) {
        this.name = name;
    }

    @Override
    public void doAction() {
        System.out.println(this);
        HashSet<Action> completedActions = new HashSet<>();
        actions.forEach(action -> {
            if (action == this.getCurrentAction() && action.completed()) {
                this.actionComplete(action);
                if (!action.isTimeTableActione()) {
                    completedActions.add(action);
                    action.runDependActions();
                } else {
                    action.runDependActions();
                    action.init();
                }
                this.currentAction = null;
            }
            if (action.needStart() && (this.currentAction == null || this.currentAction.getRange() < action.getRange())) {
                if (this.currentAction != action) {
                    this.currentAction = action;
                }
            }
        });
        // удаляем те действия, которые уже завершились для экономии памяти
        completedActions.forEach(completedAction -> this.actions.remove(completedAction));
        needs.forEach(need -> {
                need.update(this::needUpdate, this.currentAction);
            });
    }

    @Override
    public Action addNewAction(Action action) {
        this.actions.add(action);
        return action;
    }

    @Override
    public Action doRequest(Character character, Need need, Request request){
        return null;
    }
    public void addNewConductor(Conductor condictor) {
        this.conductors.add(condictor);
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        value.append(this.name)
             .append(" ");
        this.needs.forEach(need -> {
            value.append(need.getCaption()).append(" ").append(need.getValue()).append("; ");
        });
        if (currentAction != null) {
            value.append("Текущее действие: ").append(currentAction.getName());
        }
        return value.toString();
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public String getName() {
        return name;
    }

    protected void addNewNeed(Need need) {
        this.needs.add(need);
    }

    protected void needUpdate(Need need) {};
    protected Action createRequestToConductors(Need need, Request request) {
        for (Conductor conductor : this.conductors) {
            Action action = conductor.doRequest(this, need, request);
            if (action != null) {
                return action;
            }
        }
        return null;
    }
    protected void actionComplete(Action action) {}
}
