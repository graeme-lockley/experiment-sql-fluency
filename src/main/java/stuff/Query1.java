package stuff;

import java.util.List;
import java.util.function.Function;

class Query1<T1 extends TableRef> {
    private T1 table1;
    private BooleanType where;

    public Query1(T1 table1) {
        this.table1 = table1;
    }

    public Query1<T1> where(Function<T1, BooleanType> whereClause) {
        where = whereClause.apply(table1);
        return this;
    }

    public Query1<T1> orderBy(Function<Author, List<OrderByExpression>> orderBy) {
        return this;
    }

    public <T2 extends TableRef> OnQuery2<T1, T2> join(T2 table2) {
        return new OnQuery2<>(table1, table2);
    }

    public String asString() {
        return table1.asString() + " WHERE " + where.toString();
    }
}
