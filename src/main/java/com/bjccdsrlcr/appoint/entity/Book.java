package com.bjccdsrlcr.appoint.entity;

import java.lang.reflect.Field;
import java.util.Comparator;

public class Book implements Comparable{
	
	private long bookId;//图书ID
	private String name;//图书名称
	private int number;//馆藏数量 
	private String introd;
	public Book() {  //为什么要有个无参构造器
	}
	public Book(long bookId, String name, int number) { 
		this.bookId = bookId;
		this.name = name;
		this.number = number;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getIntrod() {
		return introd;
	}
	public void setIntrod(String introd) {
		this.introd = introd;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + ", introd=" + introd + "]";
	}

	public int compareTo(Object o) {
		Book book = (Book) o;
		if ((this.getNumber()- book.getNumber()) == 0){
			long CompareValue = this.getBookId() - book.getBookId();
			return (int) CompareValue;
		}else {
			return this.getNumber() - book.getNumber();
		}
	}

}
