package stuff;

public class Author {
    public static IntegerColumnReference AUTHOR_ID = new IntegerColumnReference("AUTHOR", "AUTHOR_ID");
    public static IntegerColumnReference ID_NUMBER = new IntegerColumnReference("AUTHOR", "ID_NUMBER");
    public static StringColumnReference NAME = new StringColumnReference("AUTHOR", "NAME");

    public static Author NullAuthor = null;
}
