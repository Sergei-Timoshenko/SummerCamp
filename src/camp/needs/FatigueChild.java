package camp.needs;

import camp.Timeline;
import camp.actions.Action;

import java.time.LocalDateTime;

public class FatigueChild implements Need {
    private int value;
    private LocalDateTime preTimeChangeValue;
    @Override
    public void update(NeedUpdater needUpdater, Action CurrectAction) {
        this.preTimeChangeValue = Timeline.getModelTime();

    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getCaption() {
        return "Усталость";
    }
}
