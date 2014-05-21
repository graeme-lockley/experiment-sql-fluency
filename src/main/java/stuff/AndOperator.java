package stuff;

class AndOperator implements BooleanBinaryOperator {
    private BooleanType left;
    private BooleanType right;

    AndOperator(BooleanType left, BooleanType right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return (left instanceof BinaryOperator ? ("(" + left.toString() + ")") : left.toString()) +
                " AND " +
                (right instanceof BinaryOperator ? ("(" + right.toString() + ")") : right.toString());
    }
}
