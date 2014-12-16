package stuff;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void should_support_single_table_query() throws Exception {
        Query1<Author> query = Query.from(Author.as("A"))
                .where(a -> a.NAME.like("%LOCKLEY%"))
                .orderBy(a -> Arrays.asList((OrderByExpression) a.NAME));

        assertEquals("AUTHOR as A WHERE A.NAME LIKE '%LOCKLEY%'", query.asString());
    }

    @Test
    public void should_support_binary_table_query() throws Exception {
        Query2<Author, Book> query = Query.from(Author.as("A"), Book.as("B"))
                .where((a, b) ->
                        a.NAME.like("%LOCKLEY%")
                                .and(b.TITLE.like("%RINGS%")
                                        .or(b.TITLE.like("%HOBBIT%")))
                                .and(a.AUTHOR_ID.eq(b.AUTHOR_ID)))
                .orderBy((a, b) -> Arrays.asList((OrderByExpression) a.NAME));

        assertEquals("AUTHOR as A, BOOK as B WHERE A.NAME LIKE '%LOCKLEY%' AND (B.TITLE LIKE '%RINGS%' OR B.TITLE LIKE '%HOBBIT%') AND A.AUTHOR_ID = B.AUTHOR_ID", query.asString());
    }

    @Test
    public void should_single_table_query_with_join() throws Exception {
        Query2<Author, Book> query = Query.from(Author.as("A"))
                .join(Book.as("B"))
                .on((a, b) -> a.AUTHOR_ID.eq(b.AUTHOR_ID))
                .where((a, b) ->
                        a.NAME.like("%LOCKLEY%")
                                .and(b.TITLE.like("%RINGS%")
                                        .or(b.TITLE.like("%HOBBIT%"))))
                .orderBy((author, book) -> Arrays.asList((OrderByExpression) author.NAME));

        assertEquals("AUTHOR as A, BOOK as B WHERE A.AUTHOR_ID = B.AUTHOR_ID AND A.NAME LIKE '%LOCKLEY%' AND (B.TITLE LIKE '%RINGS%' OR B.TITLE LIKE '%HOBBIT%')", query.asString());
    }
}