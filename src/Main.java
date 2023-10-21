import characters.Cook;
import characters.statuses.Roles;

import java.util.List;
import java.util.Random;

import timer.TickTimer;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        Cook cook = new Cook("Cook", Roles.COOK, null);
        List<? extends Enum> actions = cook.getCharactersMethods();
        Enum randomAction = actions.get(random.nextInt(actions.size()));
        cook.doAction(randomAction);

        TickTimer customtickTimer = new TickTimer(); // в конструктор можно передать List<Person>, на которых вызвать методы
    }
}