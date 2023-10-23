package camp;

import camp.characters.Child;
import camp.characters.Cooker;
import camp.characters.Teacher;

public class Configuration {
    static {

    }
    public static void RunModel() {
        Timeline timeline = Timeline.getTimelineInstance();
        Teacher teacher = new Teacher("Teacher");
        Cooker cooker = new Cooker("Cooker");

        Child child = new Child("");
        child.addNewConductor(teacher);
        child.addNewConductor(cooker);
        timeline.addCharacter(child);

        child = new Child("");
        child.addNewConductor(teacher);
        child.addNewConductor(cooker);
        timeline.addCharacter(child);

        child = new Child("");
        child.addNewConductor(teacher);
        child.addNewConductor(cooker);
        timeline.addCharacter(child);

        child = new Child("");
        child.addNewConductor(teacher);
        child.addNewConductor(cooker);
        timeline.addCharacter(child);

        teacher.addNewConductor(cooker);
        timeline.addCharacter(teacher);
        timeline.addCharacter(cooker);
    }
}
