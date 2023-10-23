package camp.actions;

import java.time.LocalDateTime;

public class CookerFeedChildAction extends CustomAction implements Action{
    public CookerFeedChildAction(LocalDateTime startTime, int duration) {
        super(startTime, duration);
    }

    @Override
    public String getName() {
        return "Готовит для ребенка покушать (по указанию воспитателя)";
    }

    @Override
    public void update() {
    }

    @Override
    public int getRange() {
        return 1;
    }
}
