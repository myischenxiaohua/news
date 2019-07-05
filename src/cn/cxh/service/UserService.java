package cn.cxh.service;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 10:58
*/

import cn.cxh.entity.User;

import java.sql.SQLException;

public interface UserService {
    User getUser(User user);
    boolean addUser(User user);
}
