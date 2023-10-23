package camp.actions;

import java.time.LocalDateTime;

public interface Action {
    String getName();
    int getRange();
    void addDepenAction(Action action);
    void runDependActions();
    void update();
    void init();
    boolean isTimeTableActione();
    void resume();
    boolean completed();
    boolean needStart();
}
