package cn.cxh.util;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.util
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 13:26
*/
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseUtil {
    private static final String DRIVER = ConfigManager.getProperties("driverClass");// 数据库驱动字符串
    private static final String URL = ConfigManager.getProperties("url");// 连接URL字符串
    private static final String USER = ConfigManager.getProperties("user"); // 数据库用户名
    private static final String PASSWORD = ConfigManager.getProperties("password"); // 用户密码
    private Connection conn = null;
    public DatabaseUtil(){ //构造器
        try {
            //加载驱动
            Class.forName(DRIVER);
            //创建数据库连接
            this.conn=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConn() {
//                Context ctx;
//        // 获取连接并捕获异常
//        try {
//            ctx=new InitialContext();
//            DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
//            this.conn=ds.getConnection();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return this.conn;
    }

    /**
     * 关闭数据库连接
     */
    public void close(){
        if(this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
