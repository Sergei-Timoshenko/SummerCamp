package camp.needs;

import camp.Timeline;
import camp.actions.Action;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

abstract public class CustomNeed implements Need{
    private int value = 0;
    private LocalDateTime preTimeChangeValue = null;

    public int getValue() {
        return this.value;
    }
    public void update(NeedUpdater updater, Action currectAction) {
        LocalDateTime time = Timeline.getModelTime();
        if (preTimeChangeValue != null) {
            if (ChronoUnit.MINUTES.between(preTimeChangeValue, time) >= changeValueInterval(currectAction)) {
                value = this.getNewValue(value, currectAction);
                this.preTimeChangeValue = time;
            }
        } else {
            this.preTimeChangeValue = time;
        }
        updater.update(this);
    }

    protected abstract int changeValueInterval(Action currectAction);
    protected abstract int getNewValue(int currentValue, Action currectAction);
}
