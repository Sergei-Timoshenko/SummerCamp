package camp.actions;

import java.time.LocalDateTime;

public class ChildEatAction extends CustomAction{
    public static final String NAME = "Кушает!!!";
    public ChildEatAction(LocalDateTime startTime, int duration) {
        super(startTime, duration);
    }
    @Override
    public void update() {
        System.out.println("Ребенок ест!!!!!");
    }

    @Override
    public int getRange() {
        return 10;
    }

    @Override
    public String getName() {
        return ChildEatAction.NAME;
    }
}
