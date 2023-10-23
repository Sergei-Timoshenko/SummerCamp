package camp.actions;

import java.time.LocalDateTime;

public class CookerServingFoodAction extends CustomAction implements Action{
    public static final String NAME = "Выдача еды по расписанию (завтрак, обед или ужин)";
    public CookerServingFoodAction(LocalDateTime startTime, int duration) {
        super(startTime, duration);
    }

    @Override
    public String getName() {
        return CookerServingFoodAction.NAME;
    }

    @Override
    public void update() {
    }

    @Override
    public int getRange() {
        return 1;
    }
}
