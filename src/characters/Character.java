package characters;

import characters.statuses.ActivityStatus;
import characters.statuses.NeedStatus;
import characters.statuses.Roles;

import java.util.List;

public abstract class Character {
    protected String name;
    protected Roles role;
    protected List<Character> familiars = null;     // Cписок знайомих
    protected ActivityStatus activityStatus = ActivityStatus.RESTING;
    protected NeedStatus needStatus = NeedStatus.NONE;      // Cтатус потреби
    protected int satietyLevel;     // Рівень ситості
    protected int fatigueLevel;     // Рівень втоми

    public abstract void doEat();
    public abstract void getSleep();
    public abstract void getHungry();
    public abstract void getTired();

    public abstract void changeActivity(ActivityStatus activityStatus);
    public abstract void considerNeeds(NeedStatus needStatus);
}

