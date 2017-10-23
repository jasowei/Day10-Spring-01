package com.lanou.dao;

/**
 * Created by dllo on 17/10/23.
 */
public interface UserDao {

    /**
     * 登录
     * @param name 姓名
     * @param password 密码
     * @return
     */
    boolean login(String name,String password);
}
