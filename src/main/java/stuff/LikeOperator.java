package stuff;

class LikeOperator extends BooleanOperation {
    private StringType left;
    private StringType right;

    LikeOperator(StringType left, StringType right) {
        this.left = left;
        this.right = right;
    }

    LikeOperator(StringType left, String right) {
        this.left = left;
        this.right = new StringConstant(right);
    }

    public String toString() {
        return "LIKE(" + left.toString() + ", " + right.toString() + ")";
    }
}
