package stuff;

class StringConstant implements StringType {
    private String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String toString() {
        return "\"" + value + "\"";
    }
}
