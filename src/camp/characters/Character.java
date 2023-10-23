package camp.characters;

import camp.actions.Action;

import java.time.LocalDateTime;

public interface Character {
    String getName();
    void doAction();
    Action addNewAction(Action action);
}
