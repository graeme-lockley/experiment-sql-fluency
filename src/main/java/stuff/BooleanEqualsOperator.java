package stuff;

class BooleanEqualsOperator extends BooleanOperation {
    private IntegerType left;
    private IntegerType right;

    BooleanEqualsOperator(int left, IntegerType right) {
        this.left = new IntegerConstant(left);
        this.right = right;
    }

    BooleanEqualsOperator(IntegerType left, IntegerType right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return left.toString() + " = " + right.toString();
    }
}
