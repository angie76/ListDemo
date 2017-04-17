package com.example.ang.listdemo;

public class LibraryItems {

    private String item_name;
    private String author_name;
    private int year;
    private String type;

    public LibraryItems(String item_name, String author_name, int year, String type){
        super();
        this.item_name = item_name;
        this.author_name = author_name;
        this.year = year;
        this.type = type;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

}