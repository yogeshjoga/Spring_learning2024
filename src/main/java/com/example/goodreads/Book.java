package com.example.goodreads;

public class Book{
    private int id;
    private String name;
    private String imageURL;
  

    public Book (int id, String name, String imageURL){
        this.id = id;
        this.name  = name;
        this.imageURL = imageURL;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getImageURL(){
        return this.imageURL;
    }
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }
    
}