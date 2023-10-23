package camp.needs;

import camp.actions.Action;
import camp.actions.ChildEatAction;
import camp.actions.ChildPlayAction;

public class HungaryChild extends CustomNeed{

    @Override
    public String getCaption() {
        return NeedConsts.HUNGARY;
    }

    @Override
    protected int changeValueInterval(Action currectAction) {
        return 5;
    }

    @Override
    protected int getNewValue(int currentValue, Action currentAction) {
        // голод не может превышать 100 единиц...

        if (currentAction == null) {
            return Math.min(currentValue + 1, 100);
        } else {
            if (currentAction instanceof ChildPlayAction) {
                return Math.min(currentValue + 3, 100);
            } else if (currentAction instanceof ChildEatAction) {
                return Math.max(currentValue - 10, 0);  // меньше 0 быть не может
            }
        }

        return currentValue;
    }
}
