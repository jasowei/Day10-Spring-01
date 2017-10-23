package com.lanou.test;

import com.lanou.action.UserAction;
import com.lanou.dao.UserDao;
import com.lanou.dao.impl.UserDaoImpl;
import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/23.
 */
public class UserTest {


    /**
     * 普通方式
     */
    @Test
    public void test(){
        //1. 先获得action对象
        UserAction userAction = new UserAction();
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        userAction.setService(userService);

        //2. 调用action的登录方法: action -> service(impl) -> dao(impl)
        userAction.login();
    }


    /**
     * 测试xml注入的方式
     */
    @Test
    public void testXMLDI(){
        //1. 启动spring的容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-user.xml"});//加载多个spring配置文件
        //2. 通过spring容器的getBean方法返回action对象
        UserAction action = (UserAction) context.getBean("userAction");
        //3. 调用action中的登录方法
        String login = action.login();
        System.out.println(login);
    }


    /**
     * 利用注解的方式实现 IOC(控制反转) 和 DI(依赖注入)
     */
    @Test
    public void testAnnotation(){
        //1. 启动spring容器
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-user-annotation.xml"});
        //2. 获得action对象
        UserAction userAction = (UserAction) context.getBean("userAction");
        //3. 调用action中方法
        String login = userAction.login();
        System.out.println(login);
    }

}
