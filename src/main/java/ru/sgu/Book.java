import java.util.Objects;

class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Автор: " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Book book = (Book) obj;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Книга{" + super.toString() + ", Автор='" + author + "'}";
    }


    @Override
    public Book clone() {
        Book clonedBook = (Book) super.clone();
        return clonedBook;
    }

    @Override
    public Book deepClone() {
        Book clonedGroceries = new Book(new String(this.getName()), this.getPrice(), new String(author));
        return clonedGroceries;
    }

}
