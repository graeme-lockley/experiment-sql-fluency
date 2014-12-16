package stuff;

import java.util.Arrays;

public class Main {
    public static void main(String... args) throws Exception {
        Query2<Author, Book> query = Query.from(Author.as("A"), Book.as("B"))
                .where((author, book) -> author.NAME.like("%LOCKLEY%").and(book.TITLE.like("%RINGS%").or(book.TITLE.like("%HOBBIT%"))))
                .orderBy((author, book) -> Arrays.asList((OrderByExpression) author.NAME));

        System.out.println(query.asString());
    }
}

