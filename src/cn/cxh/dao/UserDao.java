package cn.cxh.dao;

import cn.cxh.entity.User;

import java.sql.SQLException;

public interface UserDao {
    User findUser(User user) throws SQLException; //查询user
    int insertUser(User user) throws SQLException; //添加user

}
