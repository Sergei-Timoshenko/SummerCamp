package camp.actions;

import camp.Timeline;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Random;

public abstract class CustomAction implements Action {
    private LocalDateTime startTime;
    private int duration; // in minutes

    private HashSet<Action> dependenceActions = new HashSet<>();

    public static CustomAction createAction(Class<? extends CustomAction> actionClass, int duration, int minStartInterval) {
        try {
            LocalDateTime startTime = null;
            if (minStartInterval > -1) {
                startTime = LocalDateTime.from(Timeline.getModelTime()).plusMinutes(minStartInterval > 0 ? new Random().nextInt(minStartInterval) : 0);
            }
            CustomAction action = actionClass
                    .getConstructor(LocalDateTime.class, int.class)
                    .newInstance(startTime, new Random().nextInt(duration));
            return action;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CustomAction(LocalDateTime startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public abstract int getRange();

    @Override
    public abstract String getName();

    @Override
    public abstract void update();

    @Override
    public boolean completed() {
        if (startTime != null) {
            LocalDateTime dt = LocalDateTime.from(startTime);
            if (this.isTimeTableActione()) {
                LocalDateTime time = Timeline.getModelTime();
                // если год равен нулю, то это событие значит должно запускаться ежедневно
                // в определенное время (событие по расписанию)
                dt = dt.withYear(time.getYear()).withMonth(time.getMonthValue()).withDayOfMonth(time.getDayOfMonth());
                if (time.getHour() < dt.getHour() && ChronoUnit.DAYS.between(time, dt) != 0) {
                    dt = dt.minusDays(1);
                }
            }
            return dt.plusMinutes(this.duration).isBefore(Timeline.getModelTime());
        } else {
            return false;
        }
    }

    @Override
    public boolean needStart() {
        if (startTime != null) {
            LocalDateTime time = Timeline.getModelTime();
            LocalDateTime dt = LocalDateTime.from(startTime);
            if (this.isTimeTableActione()) {
                // если год равен нулю, то это событие значит должно запускаться ежедневно
                // в определенное время (событие по расписанию)
                dt = dt.withYear(time.getYear()).withMonth(time.getMonthValue()).withDayOfMonth(time.getDayOfMonth());
            }
            return dt.isBefore(time) && dt.plusMinutes(duration).isAfter(time);
        } else {
            return false;
        }
    }

    @Override
    public void addDepenAction(Action action) {
        dependenceActions.add(action);
    }
    public void runDependActions() {
        this.dependenceActions.forEach(action -> {
            action.resume();
        });
    }

    public void resume() {
        this.startTime = Timeline.getNextModelTime();
    }

    public void init() {
        this.dependenceActions.clear();
    }
    public boolean isTimeTableActione() {
        return startTime.getYear() == 0;
    }
}
