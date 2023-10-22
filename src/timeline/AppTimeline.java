package timeline;

import timeline.schedule.HourStatuses;
import timeline.schedule.Schedule;
import utils.Constants;
import characters.*;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AppTimeline {
    private static int currentTick = 0;
    private static List<MyCharacter> characterList;

    public AppTimeline(List<MyCharacter> characterList) {
        this.characterList = characterList;
    }

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
                    HourStatuses hourStatus = getHourStatus(hour);
                    for (MyCharacter character : characterList){
                        character.doAction(hourStatus);
                    }

                    System.out.println("Tick " + currentTick + " (" + hour + ") : " + hourStatus);
                }
                currentTick++;
            }
        };

        timer.schedule(task, 0, Constants.TICK_TIME);
    }


    public static HourStatuses getHourStatus(int hour) {
       return Schedule.getHourStatus(hour);
    }
}


