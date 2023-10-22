package characters.needs;

public class Need {
    private final NeedName needName;
    private int value = 0;

    public Need(NeedName needName) {
        this.needName = needName;
    }

    public NeedName getNeedType() {
        return needName;
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
                "needType=" + needName +
                ", value=" + value +
                '}';
    }
}
