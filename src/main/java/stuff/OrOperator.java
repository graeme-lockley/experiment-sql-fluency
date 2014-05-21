package stuff;

class OrOperator implements BooleanBinaryOperator {
    private BooleanType left;
    private BooleanType right;

    OrOperator(BooleanType left, BooleanType right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return (left instanceof BinaryOperator ? ("(" + left.toString() + ")") : left.toString()) +
                " OR " +
                (right instanceof BinaryOperator ? ("(" + right.toString() + ")") : right.toString());
    }
}
