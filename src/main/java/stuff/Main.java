package stuff;

import za.co.no9.util.function.Function;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) throws Exception {
        String x = new Function2<Author, Book, String>() {
            @Override
            public String apply(Author author, Book book) {
                return Builder.create()
                        .where(author.AUTHOR_ID.eq(book.AUTHOR_ID).and(book.TITLE.like("%RINGS%").or(book.TITLE.like("%HOBBIT%"))))
                        .orderBy(author.NAME, book.TITLE.desc())
                        .toString();
            }
        }.apply(Author.ref(), Book.ref());


        Query.from(Author.as("A"))
                .where(new Function<Author, BooleanType>() {
                    @Override
                    public BooleanType apply(Author author) {
                        return author.NAME.like("%LOCKLEY%");
                    }
                })
                .orderBy(new Function<Author, List<OrderByExpression>>() {
                    @Override
                    public List<OrderByExpression> apply(Author author) {
                        return Arrays.asList((OrderByExpression) author.NAME);
                    }
                });
//        .orderBy(a, b -> a.NAME)
//        .select(a, b -> List(a.AUTHOR_ID, a.NAME));


        System.out.println(x);
    }
}

class Query {
    static <T1 extends TableRef> Query1<T1> from(T1 tableRef) {
        return new Query1<T1>(tableRef);
    }
}

class Query1<T1> {
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
}

