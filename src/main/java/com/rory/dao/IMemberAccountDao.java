package com.rory.dao;

import com.rory.domain.MemberAccount;
import org.apache.ibatis.annotations.Select;

public interface IMemberAccountDao {

    @Select("select * from member_account where uid = #{uid}")
    public MemberAccount findById(Integer uid);
}
