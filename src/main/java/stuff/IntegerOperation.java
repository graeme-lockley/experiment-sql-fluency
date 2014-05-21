package stuff;

public class IntegerOperation implements IntegerType {
    public BooleanOperation eq(IntegerType integerType) {
        return new BooleanEqualsOperator(this, integerType);
    }
}
