package com.bjccdsrlcr.appoint.dao;


import com.bjccdsrlcr.appoint.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
	/*
	 * 根据id查询书
	 * 
	 */
	Book queryById(long id);
	List<Book> querySome(String name);
	//startNumber = PageNumber * recordNum,
	// SELECT * FROM book limit startNumber, recordNum;
	List<Book> queryAll(@Param("startNumber") int startNumber, @Param("recordNum") int recordNum);
	// 根据页数和每页的记录筛选记录
	//List<Book> queryByPageNumber(@Param("pageNumber") int pageNumber, @Param("recordNum") int recordNum);
	/**
	 * @param book_id
	 * @param name
	 * @param introd
	 * @param number
	 * @author bjccdsrlcr
	 * */
	void addBook(long book_id, String name, String introd, int number);


	/*减少管存数量
	 * 用返回值可判断当前库存是否还有书
	 */
	int reduceNumber(long bookId);
}
