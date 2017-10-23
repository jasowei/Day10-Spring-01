package com.lanou.dao.impl;

import com.lanou.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/10/23.
 */

/**
 * Repository : dao层注解, 如果不指定括号中的字符串, 会给当前bean一个默认id(userDaoImpl)
 *              括号中字符串是给当前bean设置一个特定的id名称(推荐)
 * */
@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Override
    public boolean login(String name, String password) {

        if (name.equals("张三") && password.equals("123")){
            return true;
        }

        return false;
    }
}
