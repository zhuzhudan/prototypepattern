package com.study.pattern.prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrices(68.3F);
        book.setPulishDate(new Date());
        book.setPulisher("电子工业出版社");

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("计算机");
        tags.add("畅销书");
        tags.add("Java");
        book.setTag(tags);

        Book cloneBook = (Book) book.clone();//介于深克隆和浅克隆之间
        System.out.println("Book:" + book);
        System.out.println("Clone Book:" + cloneBook);

        //由于在clone()中，book.tag = (ArrayList)tag.clone(); 所以地址不一样
        System.out.println("tag: "+(book.getTag() == cloneBook.getTag()));

        //但是每一项并没有进行clone，所以每一项还是原来的地址
        System.out.println("tag item: "+(book.getTag().get(0) == cloneBook.getTag().get(0)));

        Book deepCloneBook = (Book)book.deepClone();
        System.out.println("Book:" + book);
        System.out.println("Deep Clone Book:" + deepCloneBook);
        System.out.println("tag: "+(book.getTag() == deepCloneBook.getTag()));
        System.out.println("tag item: "+(book.getTag().get(0) == deepCloneBook.getTag().get(0)));

        Book shallowClone = book.shallowClone(book);
        System.out.println("Book:" + book);
        System.out.println("Shallow Clone Book:" + shallowClone);
        System.out.println("tag: "+(book.getTag() == shallowClone.getTag()));
        System.out.println("tag item: "+(book.getTag().get(0) == shallowClone.getTag().get(0)));
    }
}
