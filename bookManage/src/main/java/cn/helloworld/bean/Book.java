package cn.helloworld.bean;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookNum;
    private String bookName;
    private String authorName;
    private String kindOfBook;
    private int reader;

    public Book(String bookNum,String bookName,String authorName,String kindOfBook,int reader) {
        this.reader = reader;
        this.kindOfBook = kindOfBook;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookNum = bookNum;
    }
    private Book(){}

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
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

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }

    public int getReader() {
        return reader;
    }

    public void setReader(int reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNum='" + bookNum + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", kindOfBook='" + kindOfBook + '\'' +
                ", reader=" + reader +
                '}';
    }
}
