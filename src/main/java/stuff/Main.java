package stuff;

import za.co.no9.util.function.Function;

public class Main {
    public static BooleanType Equals(IntegerType left, IntegerType right) {
        return new BooleanEqualsOperator(left, right);
    }

    public static BooleanType Equals(int left, IntegerType right) {
        return new BooleanEqualsOperator(left, right);
    }

    public static BooleanType And(BooleanType left, BooleanType right) {
        return new AndOperator(left, right);
    }

    public static BooleanType Or(BooleanType left, BooleanType right) {
        return new OrOperator(left, right);
    }

    public static BooleanType Like(StringType left, StringType right) {
        return new LikeOperator(left, right);
    }

    public static BooleanType Like(StringType left, String right) {
        return new LikeOperator(left, right);
    }

    public static void main(String... args) throws Exception {
        String result = Builder
                .create()
                .where(
                        And(
                                Or(
                                        Equals(20, Table.ID),
                                        Equals(40, Table.ID)),
                                Equals(10, Table.ID)
                        )
                ).toString();

        System.out.println(result);

        new Function<Author, String>() {
            @Override
            public String apply(Author bob) {
                return bob.ID_NUMBER + "";
            }
        };

        String x = new Function2<Author, Book, String>() {
            @Override
            public String apply(Author author, Book book) {
                return Builder.create()
                        .where(
//                                And(
//                                        Equals(author.AUTHOR_ID, book.AUTHOR_ID),
//                                        Or(Like(book.TITLE, "%RINGS%"), Like(book.TITLE, "%HOBBIT%"))
//                                )
                                author.AUTHOR_ID.eq(book.AUTHOR_ID)
                                        .and(
                                                book.TITLE.like("%RINGS%").or(book.TITLE.like("%HOBBIT%"))
                                        )
                        )
                        .orderBy(author.NAME, book.TITLE.desc())
                        .toString();
            }
        }.apply(Author.NullAuthor, Book.NullBook);
        System.out.println(x);
    }
}


