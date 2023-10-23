package camp.characters;

import camp.Timeline;
import camp.actions.*;
import camp.needs.Need;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Cooker extends AbstractCharacter{
    public Cooker(String name) {
        super("Cooker");
        // кормежка детей по расписанию в 9, 14 и 18 часов (завтрак, обед и ужин)
        this.addNewAction(new CookerServingFoodAction(LocalDateTime.of(0, 1,1,9,0), 45));
        this.addNewAction(new CookerServingFoodAction(LocalDateTime.of(0, 1,1,14,0), 45));
        this.addNewAction(new CookerServingFoodAction(LocalDateTime.of(0, 1,1,18,0), 45));
    }

    public Action doRequest(Character character, Need need, Request request) {
        // если запрос на кормежку ребенка пришел от воспитателя, то тогда
        // повар будет действовать. Если от ребенка, то ничего не делаем - пускай ждет
        // обеда по расписанию.
        if (character.getName().split("_")[0].equals("Teacher") ) {
            // пришло обращение от воспитателя на то, чтобы покормить ребенка
            switch (request) {
                case FEED_CHILD -> {
                    System.out.println(this.getName() + " принял запрос на " + "'Покормить ребенка' от " + character.getName());
                    Action feedChild = CustomAction.createAction(CookerFeedChildAction.class, 45, 0);
                    this.addNewAction(feedChild);
                    return feedChild;
                }
                case EAT -> System.out.println("Кушать от ребенка");
            }
        }
        return null;
    }

    @Override
    public void doAction() {
        super.doAction();
        if (this.getCurrentAction() != null && this.getCurrentAction().getName().equals(CookerServingFoodAction.NAME)) {
            Iterator<Character> allCharacters = Timeline.getTimelineInstance().getAllCharacters();
            while(allCharacters.hasNext()) {
                Character character = allCharacters.next();
                if (character.getName().split("_")[0].equals("Child")) {
                    Action eatAction = CustomAction.createAction(ChildEatAction.class, 30, -1);
                    this.getCurrentAction().addDepenAction(eatAction);
                    character.addNewAction(eatAction);
                }
            }
        }
    }
}
