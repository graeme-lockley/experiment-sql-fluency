package stuff;

public class TrimOperation extends StringOperation implements OrderByExpression {
    private final StringOperation item;

    public TrimOperation(StringOperation item) {
        this.item = item;
    }

    public String toString() {
        return "TRIM(" + item.toString() + ")";
    }
}
