package cn.cxh.dao.impl;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.dao.impl
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 13:39
*/

import cn.cxh.dao.NewsDao;
import cn.cxh.entity.News;
import cn.cxh.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    public NewsDaoImpl(Connection conn) {
        super(conn);
    }
    @Override
    public List<News> findNews() throws SQLException {
        String sql="select * from news";
        ResultSet rst=super.executeQuery(sql);
        List<News> newsList=new ArrayList<>();
        News news=null;
        while (rst.next()){
            news=new News();
            news.setNid(rst.getInt("nid"));
            news.setNtid(rst.getInt("ntid"));
            news.setNtitle(rst.getString("ntitle"));
            news.setNauthor(rst.getString("nauthor"));
            System.out.println(rst.getString("ntitle"));
            newsList.add(news);
        }


        return newsList;

    }

    @Override
    public int updateNews(News news) throws SQLException {
        String sql="update news set ntid=?," +
                "ntitle=?," +
                "nauthor=?," +
                "nsummary=?," +
                "ncontent=?," +
                "nmodifyDate=?, "+
                "npicPath=? "+
                "where nid=?";
        return super.executeUpdate(
                sql,
                news.getNtid(),
                news.getNtitle(),
                news.getNauthor(),
                news.getNsummary(),
                news.getNcontent(),
                news.getNmodifydate(),
                news.getNpicpath(),
                news.getNid()
        );

    }



    @Override
    public News findById(int id) throws SQLException {
        String sql="select * from news where nid=?";
        ResultSet rst= super.executeQuery(sql,id);
        News news=new News();

        if (rst.next()) {
            news.setNid(rst.getInt("nid"));
            news.setNtid(rst.getInt("ntid"));
            news.setNtitle(rst.getString("ntitle"));
            news.setNauthor(rst.getString("nauthor"));
            news.setNsummary(rst.getString("nsummary"));
            news.setNcontent(rst.getString("ncontent"));
            news.setNpicpath(rst.getString("npicpath"));
        }
        return news;
    }

    @Override
    public int insertNews(News news) throws SQLException {
        String sql="insert into news(ntid,ntitle,nauthor,nsummary,ncontent,npicPath) values(?,?,?,?,?,?)";
        return super.executeUpdate(sql,news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),news.getNcontent(),news.getNpicpath());
    }

    @Override
    public int delNewsById(int id) throws SQLException {
        String sql="delete from news where nid=?";
        return super.executeUpdate(sql,id);

    }

    @Override
    public List<News> findPageNews(Page page) throws SQLException {
        String sql="select * from news limit ?,?";
        System.out.println(page.getCurrPageNo());
        int startPage=(page.getCurrPageNo()-1)*page.getPageSize();

      ResultSet rst= super.executeQuery(sql,startPage,page.getPageSize());
        List<News> newsList=new ArrayList<>();
        News news=null;
        while (rst.next()){
            news=new News();
            news.setNid(rst.getInt("nid"));
            news.setNtid(rst.getInt("ntid"));
            news.setNtitle(rst.getString("ntitle"));
            news.setNauthor(rst.getString("nauthor"));
            System.out.println(rst.getString("ntitle"));
            newsList.add(news);
        }
        return newsList;

    }

    @Override
    public int countNews() throws SQLException {
        String sql="select count(1) from news";

        ResultSet rst=super.executeQuery(sql);
        if (rst.next())
            return  rst.getInt(1);
        return 0;
    }

    @Override
    public List<News> findByTid(int tid) throws SQLException {
        String sql="select * from news where ntid=?";
       ResultSet rst=super.executeQuery(sql,tid);
        List<News> newsList=new ArrayList<>();
        News news=null;
        while (rst.next()){
            news=new News();
            news.setNid(rst.getInt("nid"));
            news.setNtid(rst.getInt("ntid"));
            news.setNtitle(rst.getString("ntitle"));
            news.setNauthor(rst.getString("nauthor"));
            System.out.println(rst.getString("ntitle"));
            newsList.add(news);
        }
        return newsList;

    }
}
