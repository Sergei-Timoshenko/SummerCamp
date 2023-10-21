package characters.actions;

public interface CharacterActions {
    public <T extends Enum> void doAction(T action);
}
