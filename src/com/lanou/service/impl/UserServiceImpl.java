package com.lanou.service.impl;

import com.lanou.dao.UserDao;
import com.lanou.dao.impl.UserDaoImpl;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by dllo on 17/10/23.
 */


/**
 * Service : service层bean注解, 指定当前bean对应的id为userService
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * @Autowired : 按照类型匹配
     * @Qualifier : 按照注入id名称匹配, 更加精确
     *通常将两个注解一起使用
     */
    @Qualifier("userDao")
    @Autowired
    private UserDao userDao = new UserDaoImpl();//dao层对象

    @Override
    public boolean login(String name, String pwd) {
        //调用dao层登录方法
        return userDao.login(name,pwd);
    }

    /**
     * userdao对象对外提供get/set方法
     * @return
     */
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
