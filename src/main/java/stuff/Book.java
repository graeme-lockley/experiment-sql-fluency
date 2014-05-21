package stuff;

public class Book {
    public static IntegerColumnReference BOOK_ID = new IntegerColumnReference("BOOK", "BOOK_ID");
    public static StringColumnReference TITLE = new StringColumnReference("BOOK", "TITLE");
    public static IntegerColumnReference AUTHOR_ID = new IntegerColumnReference("BOOK", "AUTHOR_ID");

    public static Book NullBook = new Book();
}
