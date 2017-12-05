package com.bjccdsrlcr.appoint.comparator;

import com.bjccdsrlcr.appoint.entity.Book;

import java.util.Comparator;

/**
 * Author: bjccdsrlcr
 * Date: 2017/12/5 0005
 * Time: 14:53
 */
public class BookComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        if(book1.getNumber() < book2.getNumber()){
            return 1;
        }else {
            return 0;
        }
    }
}
