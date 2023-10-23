package characters.needs;

import characters.enums.Role;
import characters.needs.NeedName;

public enum RoleNeedName {
    ;
    public enum ChildNeedName implements NeedName {
        FOOD, PlAY, SLEEP
    }
    public enum TutorNeedName implements NeedName {
        ATTENTION
    }
    public enum CookNeedName implements NeedName {
        PRODUCTS
    }

    public static NeedName[] getCharacterNeeds(Role roles) {
        return switch (roles) {
            case TUTOR -> TutorNeedName.values();
            case COOK -> CookNeedName.values();
            default ->  ChildNeedName.values();
        };
    }
}

