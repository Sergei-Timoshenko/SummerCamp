package timeline.schedule;

public class Schedule {
    public static HourStatuses getHourStatus(int hour) {
        return switch (hour) {
            case 0, 1, 2, 3, 4, 5, 6, 22, 23 -> HourStatuses.SLEEP;
            case 7 -> HourStatuses.WAKE_UP;
            case 9 -> HourStatuses.BREAKFAST;
            case 14 -> HourStatuses.LUNCH;
            case 19 -> HourStatuses.DINNER;
            case 21 -> HourStatuses.GO_TO_BED;
            default -> HourStatuses.FREE_TIME;
        };
    }
}
