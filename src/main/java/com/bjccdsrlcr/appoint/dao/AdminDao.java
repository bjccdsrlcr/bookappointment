package com.bjccdsrlcr.appoint.dao;

import com.bjccdsrlcr.appoint.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin queryAdmin(@Param("adminId") long adminId, @Param("password")String password);

}
