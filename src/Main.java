import characters.AbstractCharacter;
import characters.Child;
import characters.Tutor;
import characters.needs.Need;
import characters.enums.Role;
import timeline.AppTimeline;
import characters.Cook;

import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AbstractCharacter child = new Child(Role.CHILD);
        AbstractCharacter tutor = new Tutor(Role.TUTOR);
        AbstractCharacter cook = new Cook(Role.COOK);

        ArrayList<AbstractCharacter> characters = new ArrayList<>();
        characters.add(child);
        characters.add(tutor);
        characters.add(cook);

        AppTimeline appTimeline = new AppTimeline(characters);
        appTimeline.run();
    }
}