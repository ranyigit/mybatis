package com.rory.dao;

import com.rory.domain.Comment;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICommentDao {

    @Select("select * from comment where uid = #{uid}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "uid",property = "uid"),
        @Result(column = "msg",property = "msg"),
        @Result(column = "created_time",property = "createdTime")
    })
    List<Comment> findAllById(Integer uid);
}
