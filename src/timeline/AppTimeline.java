package timeline;

import utils.Constants;
import characters.*;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AppTimeline {
    private static int currentTick = 7 * Constants.TICKS_IN_HOUR;
    private final List<AbstractCharacter> characters;

    public AppTimeline(List<AbstractCharacter> characterList) {
        this.characters = characterList;
    }

    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (currentTick == 21 * Constants.TICKS_IN_HOUR) {
                    cancel();
                }

                characters.forEach(character -> character.doAction(currentTick));
                currentTick++;
            }
        };

        timer.schedule(task, 0, Constants.TICK_TIME);
    }

}


