package characters.roles;

import characters.needs.NeedType;

public enum RoleNeeds {
    ;
    public enum ChildNeeds implements NeedType {
        FOOD, PlAY, SLEEP
    }
    public enum TutorNeeds implements NeedType {
        ATTENTION
    }
    public enum CookNeeds implements NeedType {
        PRODUCTS
    }

    public static NeedType[] getCharacterNeeds(Roles role) {
        return switch (role) {
            case TUTOR -> TutorNeeds.values();
            case COOK -> CookNeeds.values();
            default ->  ChildNeeds.values();
        };
    }
}

