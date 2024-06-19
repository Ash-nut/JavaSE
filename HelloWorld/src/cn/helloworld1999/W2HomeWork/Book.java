package cn.helloworld1999.W2HomeWork;

public class Book {
    private String bookName;
    private String authorName;
    private double price;

    public Book(String bookName,String authorName,double price){
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", authorName=" + authorName + ", price=" + price + "]";
    }


    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
