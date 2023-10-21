package characters;

import characters.actions.CharacterActions;
import characters.statuses.ActivityStatus;
import characters.statuses.NeedStatus;
import characters.statuses.Roles;

import java.util.List;

public class Cook extends Character implements CharacterActions {

    private int productLevel;

    public Cook(String name, Roles role, List<Character> familiars) {
        this.name = name;
        this.role = role;
        this.familiars = familiars;
        this.charactersMethods = Character.CharacterVariability.getCharacterMethods(this.role);
    }
    @Override
    public void doEat() {
        // TODO
    }

    @Override
    public void getSleep() {
        // TODO
    }

    @Override
    public void getHungry() {
        satietyLevel--;
    }

    @Override
    public void getTired() {
        fatigueLevel++;
    }

    public int getProductLevel() {
        return productLevel;
    }

    public void addProducts(int productsCount) {
        productLevel += productsCount;
    }

    @Override
    public int getCurrentSatietyLevel() {
        return satietyLevel;
    }

    @Override
    public int getCurrentFatigueLevel() {
        return fatigueLevel;
    }

    @Override
    public void changeActivity(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Override
    public void considerNeeds(NeedStatus needStatus) {
        this.needStatus = needStatus;
    }

    @Override
    public <T extends Enum> void doAction(T action) {
        System.out.println(action.name());
    }
}
