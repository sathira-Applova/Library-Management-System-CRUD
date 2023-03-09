package org.userwebapp.model;

public class Book {
    //properties
    private String bName, bookID;
    private int noOfCopies;

    public Book(){}

    public Book(String bookID, String bName, int noOfCopies){
        this.bookID = bookID;
        this.bName = bName;
        this.noOfCopies = noOfCopies;
    }

    //getters and setters
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
}

