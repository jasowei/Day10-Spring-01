package com.lanou.action;

import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/23.
 */


/**
 * @Controller : action层的bean注解
 * @Scope : Action层中的对象定义需要声明为每次自动创建
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {


    /**
     * bean 中的属性注入
     */
    @Qualifier("userService")
    @Autowired
    private UserService service ;//service层的访问对象

    /**
     * 登录
     * @return
     */
    public String login(){
        //调用service层的登录方法
        if (service.login("张三","123")){
            return "success";
        }
        return "error";
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
