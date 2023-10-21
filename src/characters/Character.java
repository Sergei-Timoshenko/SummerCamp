package characters;

import java.util.List;

public abstract class Character {
    protected String name;
    // список знайомих
    protected List<Character> familiars;
    protected ActivityStatus activityStatus = ActivityStatus.RESTING;
    // статус потреби
    protected NeedStatus needStatus = NeedStatus.NONE;
    // Рівень ситості
    protected int satietyLevel;
    // Рівень втоми
    protected int fatigueLevel;

    public abstract void doEat();
    public abstract void getSleep();
}

