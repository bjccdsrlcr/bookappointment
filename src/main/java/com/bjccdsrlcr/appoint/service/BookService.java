package com.bjccdsrlcr.appoint.service;


import com.bjccdsrlcr.appoint.dto.AppointExecution;
import com.bjccdsrlcr.appoint.entity.Appointment;
import com.bjccdsrlcr.appoint.entity.Book;
import com.bjccdsrlcr.appoint.entity.Student;

import java.util.List;

public interface BookService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);

	void addBook(long book_id, String name, String introd, int number);
	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Book> getList();
	/**
	 * 登陆时查询数据库是否有该学生记录。
	 */
	Student validateStu(Long studentId, Long password);
	/**按照图书名称查询
	 * 按条件搜索图书
	 * 
	 */ 
	List<Book> getSomeList(String name);
	/*
	 * 查看某学生预约的所有图书
	 * 
	 */
	List<Appointment> getAppointByStu(long studentId);
	/**
	 * 预约图书
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appoint(long bookId, long studentId);//返回预约成功的实体类
}
