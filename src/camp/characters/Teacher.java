package camp.characters;

import camp.actions.Action;
import camp.actions.ChildEatAction;
import camp.actions.CustomAction;
import camp.needs.Need;

public class Teacher extends AbstractCharacter{
    public Teacher(String name) {
        super("Teacher");
    }

    @Override
    public Action doRequest(Character character, Need need, Request request) {
        if (character.getName().split("_")[0].equals("Child") ) {
            // надо кормить ребенка. Создаем для этого действие для повара
            // на выдачу еды ребенку
            Action feedAction = this.createRequestToConductors(null, Request.FEED_CHILD);
            if (feedAction != null) {
                // воспитатель создает для ребенка действие "кушать", которое начнется тогда, когда
                // повар подготовит еду, т.е. завершится событие CookerFeedChildAction (это действие
                // возвращается методом createRequestToConductors)
                Action eatAction = CustomAction.createAction(ChildEatAction.class, 30, -1);
                feedAction.addDepenAction(eatAction);
                // ребенку добавили действие "кушать"
                character.addNewAction(eatAction);
                return eatAction;
            } else {
                return null;
            }
        }
        return null;
    }
}
