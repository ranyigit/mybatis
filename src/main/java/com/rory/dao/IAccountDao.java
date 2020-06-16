package com.rory.dao;

import com.rory.domain.Account;
import com.rory.domain.AccountUser;
import org.apache.ibatis.annotations.Results;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账号,同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    List<AccountUser> findAllUserAccount();

    @Results()
    List<Account> findOneByOne();
}
