package camp;

import camp.characters.Character;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class Timeline {
    private static final int MODEL_TIME_STEP = 1;
    private static Timeline timelineInstance = null;
    private static LocalDateTime time = LocalDateTime.now();
    private HashSet<Character> characters = new HashSet<>();
    public void addCharacter(Character character) {
        characters.add(character);
    }

    private Timeline() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                characters.forEach(character -> character.doAction());
                Timeline.time = Timeline.time.plusMinutes(MODEL_TIME_STEP);
                System.out.println("  *************   время внутри модели : " + Timeline.time);
            }
        }, 1000, 100);
    }

    public static Timeline getTimelineInstance() {
        if (timelineInstance == null) {
            timelineInstance = new Timeline();
        }
        return timelineInstance;
    }
    public static LocalDateTime getModelTime() {
        return Timeline.time;
    }

    public static LocalDateTime getNextModelTime() {
        return Timeline.time.plusMinutes(MODEL_TIME_STEP);
    }

    public Iterator<Character> getAllCharacters() {
        return Timeline.timelineInstance.characters.iterator();
    }
}
