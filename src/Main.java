import characters.Character;
import characters.Child;
import characters.needs.Need;
import characters.roles.Roles;
import timeline.Timeline;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character child = new Child(Roles.CHILD);
        ArrayList<Need> childNeeds = child.getNeeds();
        childNeeds.forEach(child::updateNeedValue);
        childNeeds.forEach(System.out::println);
        Timeline.run();
    }
}