package com.rory.dao;

import com.rory.domain.Member;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IMemberDao {

    // 一对一  一对多实现
    @Select("select * from member")
    @Results(value = {
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "mobile",property = "mobile"),
            @Result(column = "address",property = "address"),
            @Result(column = "created_time",property = "createdTime"),
            @Result(column = "id",property = "memberAccount", one = @One(select = "com.rory.dao.IMemberAccountDao.findById",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "comments", many = @Many(select = "com.rory.dao.ICommentDao.findAllById", fetchType = FetchType.LAZY))
    })
    List<Member> findAll();

}
