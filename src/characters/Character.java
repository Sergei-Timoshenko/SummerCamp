package characters;

import characters.statuses.ActivityStatus;
import characters.statuses.NeedStatus;
import characters.statuses.Roles;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected Roles role;
    protected List<Character> familiars = null;     // Cписок знайомих
    protected List<? extends Enum> charactersMethods = null;
    protected ActivityStatus activityStatus = ActivityStatus.RESTING;
    protected NeedStatus needStatus = NeedStatus.NONE;      // Cтатус потреби
    protected int satietyLevel = 30;     // Рівень ситості
    protected int fatigueLevel = 0;     // Рівень втоми

    public abstract void doEat();
    public abstract void getSleep();
    public abstract void getHungry();
    public abstract void getTired();

    public abstract int getCurrentSatietyLevel();
    public abstract int getCurrentFatigueLevel();

    public List<? extends Enum> getCharactersMethods() {
        return charactersMethods;
    }

    public abstract void changeActivity(ActivityStatus activityStatus);
    public abstract void considerNeeds(NeedStatus needStatus);

    static class CharacterVariability {
        private enum ChildVariability {
            PLAY, STUDY, GET_SLEEP, WAKE_UP, ASK_FOR_FOOD,
        }
        private enum TutorVariability {
            WAKE_UP, TEACH, GET_SLEEP
        }
        private enum CookVariability {
            WAKE_UP, COOK, GO_TO_GROCERY, GET_SLEEP
        }

        public static ArrayList<? extends Enum> getCharacterMethods(Roles role) {
            if (role == Roles.CHILD) {
                return new ArrayList<>(List.of(ChildVariability.values()));
            }
            if (role == Roles.TUTOR) {
                return new ArrayList<>(List.of(TutorVariability.values()));
            }
            return new ArrayList<>(List.of(CookVariability.values()));
        }
    }
}



