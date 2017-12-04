package com.bjccdsrlcr.appoint.dao;

import com.bjccdsrlcr.appoint.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
	/**
	 * 向数据库验证输入的密码是否正确
	 */
	Student quaryStudent(@Param("studentId") String studentId, @Param("password") String password);
}
