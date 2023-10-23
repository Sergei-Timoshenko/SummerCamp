package timeline.schedule;

import timeline.enums.HourCode;

public class Schedule {
    public static HourCode getHourStatus(int hour) {
        return switch (hour) {
            case 0, 1, 2, 3, 4, 5, 6, 22, 23 -> HourCode.SLEEP;
            case 7 -> HourCode.WAKE_UP;
            case 9 -> HourCode.BREAKFAST;
            case 14 -> HourCode.LUNCH;
            case 19 -> HourCode.DINNER;
            case 21 -> HourCode.GO_TO_BED;
            default -> HourCode.FREE_TIME;
        };
    }
}
