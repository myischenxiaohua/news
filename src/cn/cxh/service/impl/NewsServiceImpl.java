package cn.cxh.service.impl;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service.impl
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 9:28
*/

import cn.cxh.dao.NewsDao;
import cn.cxh.dao.impl.NewsDaoImpl;
import cn.cxh.entity.News;
import cn.cxh.service.NewsService;
import cn.cxh.util.DatabaseUtil;
import cn.cxh.util.Page;

import java.sql.SQLException;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private DatabaseUtil msql=new DatabaseUtil();
    private NewsDao newsDao=new NewsDaoImpl(msql.getConn());
    @Override
    public List<News> getNewsList() throws SQLException {

        try {
         return newsDao.findNews();
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            msql.close();
        }

    }

    @Override
    public News getNewsById(int id) throws SQLException {
        try {
            return newsDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            msql.close();
        }

    }

    @Override
    public boolean updateNews(News news) {
        boolean flag=false;
        try {
            if(newsDao.updateNews(news)>0){
                flag=true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            msql.close();
        }
        return flag;
    }

    @Override
    public boolean saveNews(News news) {
        try {
            return new NewsDaoImpl(msql.getConn()).insertNews(news)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存新闻失败");
        }
    }

    @Override
    public boolean delNewsById(int id) throws SQLException {
        try {
            return new NewsDaoImpl(msql.getConn()).delNewsById(id)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }
    }

    @Override
    public List<News> getPageNews(Page page) throws SQLException {
        try {
            return new NewsDaoImpl(msql.getConn()).findPageNews(page);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            msql.close();
        }
    }

    @Override
    public int countNews() throws SQLException {

        try {
            return newsDao.countNews();
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            msql.close();
        }
    }

    @Override
    public List<News> getTopicNews(int tid) throws SQLException {
        try {
            return newsDao.findByTid(tid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            msql.close();
        }
    }
}
