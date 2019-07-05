package cn.cxh.service.impl;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service.impl
  User: myischenxiaohua@163.com
  Date: 2019/6/29
  Time: 15:51
*/

import cn.cxh.dao.UserDao;
import cn.cxh.dao.impl.UserDaoImpl;
import cn.cxh.entity.User;
import cn.cxh.service.UserService;
import cn.cxh.util.DatabaseUtil;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    DatabaseUtil msql=new DatabaseUtil();
    private UserDao userDao=new UserDaoImpl(msql.getConn());
    @Override
    public User getUser(User user){

        try {
            user= userDao.findUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            msql.close();
        }

        return user;
    }

    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try {
            if(userDao.insertUser(user)>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
