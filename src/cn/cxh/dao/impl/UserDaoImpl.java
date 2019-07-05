package cn.cxh.dao.impl;

import cn.cxh.dao.UserDao;
import cn.cxh.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {


    public UserDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public User findUser(User user) throws SQLException {
        String sql="select * from news_users where uname=?";
        ResultSet resultSet=super.executeQuery(sql,user.getuName());
        if (resultSet.next()){
            user.setId(resultSet.getInt("uid"));
            user.setuName(resultSet.getString("uname"));
            user.setuPwd(resultSet.getString("upwd"));
            user.setRole(resultSet.getInt("role"));
        }
        return user;
    }

    @Override
    public int insertUser(User user) throws SQLException {

        String sql="insert into news_users(uname,upwd) values(?,?)";
        System.out.println("insertUser");
        return super.executeUpdate(sql,user.getuName(),user.getuPwd());

    }

}
