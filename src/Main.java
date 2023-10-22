import characters.Child;
import characters.needs.Need;
import characters.enums.Role;
import timeline.AppTimeline;
import characters.Cook;

import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        Cook cook = new Cook("Cook", Role.COOK, null);
        List<? extends Enum> actions = cook.getCharactersMethods();
        Enum randomAction = actions.get(random.nextInt(actions.size()));
        cook.doAction(randomAction);
        Character child = new Child(Role.CHILD);
        ArrayList<Need> childNeeds = child.getNeeds();
        childNeeds.forEach(child::updateNeedValue);
        childNeeds.forEach(System.out::println);
        AppTimeline.run();
    }
}