package stuff;

class Builder {
    private BooleanType booleanType;
    private OrderByExpression[] orderSeq;

    private Builder() {
    }

    static Builder create() {
        return new Builder();
    }

    public Builder where(BooleanType booleanType) {
        this.booleanType = booleanType;
        return this;
    }

    public Builder orderBy(OrderByExpression... orderSeq) {
        this.orderSeq = orderSeq;
        return this;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(booleanType.toString());

        if (orderSeq != null && orderSeq.length > 0) {
            result.append (" ORDER BY ");
            for (int i = 0; i < orderSeq.length; i += 1) {
                if (i > 0) {
                    result.append(", ");
                }
                result.append(orderSeq[i].toString());
            }
        }

        return result.toString();
    }
}
