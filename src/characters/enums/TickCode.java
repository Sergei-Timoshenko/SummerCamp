package characters.enums;

import utils.Constants;

public enum TickCode {
    BREAKFAST_PREPARATION(8 * Constants.TICKS_IN_HOUR - Constants.TICKS_IN_HOUR / 2),
    LUNCH_PREPARATION(14 * Constants.TICKS_IN_HOUR - Constants.TICKS_IN_HOUR / 2),
    DINNER_PREPARATION(19 * Constants.TICKS_IN_HOUR - Constants.TICKS_IN_HOUR / 2);

    private int tick;
    TickCode(int tick) {
        this.tick = tick;
    }

    public static TickCode getSchedule(int currentTick) {
        if (currentTick == BREAKFAST_PREPARATION.tick) {
            return BREAKFAST_PREPARATION;
        }
        if (currentTick == LUNCH_PREPARATION.tick) {
            return LUNCH_PREPARATION;
        }
        if (currentTick == DINNER_PREPARATION.tick) {
            return DINNER_PREPARATION;
        }
        return null;
     }
}
