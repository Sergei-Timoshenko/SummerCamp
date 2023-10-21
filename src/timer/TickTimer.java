package timer;

import java.util.Timer;
import java.util.TimerTask;

public class TickTimer {
    private Timer timer = new Timer();
    private int tickCount = 1;
    private int tickLimit = 25;
    private int interval = 1000;

    //private List<Person> personList; ожидает получение списка персонажей в конструктор для запуска задачи

    public TickTimer() {

        scheduleTickTask();
    }

    private void scheduleTickTask() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (tickCount < tickLimit) {
                    //здесь можно вызвать методы personList, которые были переданы
                    System.out.println("Тик: " + tickCount);
                    tickCount++;
                } else {
                    // если достигнуто ограничение, то перезапускает задачу
                    this.cancel();
                    tickCount = 1;
                    scheduleTickTask();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, interval);
    }
}