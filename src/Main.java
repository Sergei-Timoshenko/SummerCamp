import characters.Character;
import characters.Child;
import characters.roles.Roles;
import timeline.Timeline;

public class Main {
    public static void main(String[] args) {
        Character child = new Child(Roles.CHILD);
        child.showNeeds();
        Timeline.run();
    }
}