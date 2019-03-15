package com.study.pattern.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements Cloneable, Serializable {
    private String title;
    private float prices;
    private String pulisher;
    private String author;
    private Date pulishDate;

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    private ArrayList<String> tag;

    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    public void setPulisher(String pulisher) {
        this.pulisher = pulisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPulishDate(Date pulishDate) {
        this.pulishDate = pulishDate;
    }

    public String getTitle() {
        return title;
    }

    public float getPrices() {
        return prices;
    }

    public String getPulisher() {
        return pulisher;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPulishDate() {
        return pulishDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        book.pulishDate = new Date();
        book.tag = (ArrayList)tag.clone();
        return book;
    }

    public Object deepClone() {
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Book copy = (Book)objectInputStream.readObject();
            copy.pulishDate = new Date();
            return copy;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Book shallowClone(Book target){
        Book book = new Book();
        book.tag = target.tag;
        book.pulishDate = new Date();
        book.author = target.author;
        book.prices = target.prices;
        book.pulisher = target.pulisher;
        book.title = target.title;
        return book;
    }
}
