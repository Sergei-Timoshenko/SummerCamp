package timeline;

import timeline.schedule.HourStatuses;
import timeline.schedule.Schedule;
import utils.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class Timeline {
    private static int currentTick = 0;
    private static Enum<HourStatuses> hourStatus;

    public static void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                boolean isFinalTick = (currentTick + 1) == Constants.TICKS_ID_DAY;
                if (isFinalTick) {
                    System.out.println("Final tick: " + currentTick);
                    cancel();
                }
                if (!isFinalTick && currentTick % Constants.TICKS_IN_HOUR == 0 ) {
                    int hour = currentTick / Constants.TICKS_IN_HOUR;
                    setHourStatus(hour);
                    System.out.println("Tick " + currentTick + " (" + hour + ") : " + hourStatus);
                }
                currentTick++;
            }
        };

        timer.schedule(task, 0, Constants.TICK_TIME);
    }


    public static void setHourStatus(int hour) {
        Timeline.hourStatus = Schedule.getHourStatus(hour);
    }
}


