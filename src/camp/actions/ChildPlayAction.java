package camp.actions;

import java.time.LocalDateTime;

public class ChildPlayAction extends CustomAction implements Action {
    public ChildPlayAction(LocalDateTime startTime, int duration) {
        super(startTime, duration);
    }

    @Override
    public String getName() {
        return "Играет";
    }

    @Override
    public void update() {
    }

    @Override
    public int getRange() {
        return 1;
    }
}
