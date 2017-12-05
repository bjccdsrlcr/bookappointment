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
	List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * @param book_id
	 * @param name
	 * @param introd
	 * @param number
	 * @author bjccdsrlcr
	 * */
	void addBook(long book_id, String name, String introd, int number);


	List<Book> sortByNumber();
	/*减少管存数量
	 * 用返回值可判断当前库存是否还有书
	 */
	int reduceNumber(long bookId);
}
