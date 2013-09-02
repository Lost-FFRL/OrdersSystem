package com.os.test;

import java.util.LinkedList;
import java.util.List;

import com.os.bean.User;
import com.os.dao.UserDao;
import com.os.dao.impl.UserDaoImpl;

public class UserTest
{
//    public static void main(String[] args)
//    {
////        add();
////        del();
//        isExists();
////        update();
////        query();
//    }
    
    public static void add()
    {
        UserDao dao = new UserDaoImpl();
        List<User> list = new LinkedList<User>();
        User user = null;
        for (int i = 0; i < 5; i++)
        {
            user = new User();
            user.setNumber("os_" + i);
            user.setName("Jack_"+ i);
            user.setDesc("风扶弱柳" + i);
            user.setSex(i%2);
            user.setPhone("1355555" + i);
            user.setMobile("136666" + i);
            user.setAccount("FFRL_" + i);
            user.setPassword("123456");
            user.setAddress("Address" + i);
            user.setRemark("备注风扶弱柳" + i);
            list.add(user);
        }
        dao.add(list);
    }
    
    public static void del()
    {
        UserDao dao = new UserDaoImpl();
        dao.delete("11,12");
        dao.delUpdateByIds("13,15");
    }
    
    public static void update()
    {
        UserDao dao = new UserDaoImpl();
        
        User user = new User();
        user.setNumber("1");
        user.setName("1");
        user.setDesc("1");
        user.setSex(1);
        user.setPhone("1");
        user.setMobile("1");
        user.setAccount("1");
        user.setPassword("1");
        user.setAddress("1");
        user.setRemark("1");
        user.setId(14);
        dao.update(user);
    }
    
    public static void isExists()
    {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setName("Jack_3");
        user.setAccount("FFRL_3" );
        if (dao.isExists(user))
        {
            System.out.println("所查的用户存在");
        }
        
    }
    
    public static void query()
    {
        UserDao dao = new UserDaoImpl();
        
        User user = new User();
        user.setNumber("os");
//        List<User> list = dao.query(user);
//        for (User u : list)
//        {
//            System.out.println("查询结果" + u.toString());
//        }
    }
    
}
