package camp.characters;

import camp.actions.Action;
import camp.actions.ChildEatAction;
import camp.actions.CustomAction;
import camp.actions.ChildPlayAction;
import camp.needs.FatigueChild;
import camp.needs.HungaryChild;
import camp.needs.Need;
import camp.needs.NeedConsts;

import java.time.LocalDateTime;
import java.util.Random;

public class Child extends AbstractCharacter {
    private static int cnt = 0;
    private boolean eatActionWaiting = false;
    public Child(String name) {
        super("Child_" + cnt);
        this.addNewNeed(new HungaryChild());
        this.addNewNeed(new FatigueChild());
        cnt++;
    }

    @Override
    public void doAction() {
        super.doAction();
        Random r = new Random();
        int val = r.nextInt(100);
        // ребенок, если ничем не занят, то с вероятностью 5% начнет играть
        // игра длится от 1 до 60 минут
        if (val <= 5 && this.getCurrentAction() == null) {
            this.addNewAction(CustomAction.createAction(ChildPlayAction.class, 60, 0));
        }
    }

    @Override
    protected void needUpdate(Need need) {
        if (need.getCaption().equals(NeedConsts.HUNGARY)) {
            // ребенок изголодался на 60 единиц и начинает просить
            // тех, кому он подчиняется (воспитатель и т.д.), чтобы они
            // его покормили
            if (need.getValue() > 10 && !eatActionWaiting) {
                Action action = this.createRequestToConductors(need, Request.EAT);
                // если действие от вернулось вернулось, то значит, что этот запрос от ребенка
                // находится в процессе решения и больше беспокоить воспитеаттеля не нужно
                eatActionWaiting = action != null;
            }
        }
    }
    @Override
    protected void actionComplete(Action action) {
        if (action.getName().equals(ChildEatAction.NAME)) {
            eatActionWaiting = false;
        }
    }
}
