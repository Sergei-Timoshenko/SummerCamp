package camp.needs;

import camp.actions.Action;

public interface Need {
    int getValue();
    String getCaption();
    void update (NeedUpdater updater, Action currectAction);

}
