package characters.needs;

public class Need {
    private final NeedType needType;
    private int value = 0;

    public Need(NeedType needType) {
        this.needType = needType;
    }

    public NeedType getNeedType() {
        return needType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Need{" +
                "needType=" + needType +
                ", value=" + value +
                '}';
    }
}
