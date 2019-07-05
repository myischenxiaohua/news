package cn.cxh.service;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 9:20
*/

import cn.cxh.entity.News;
import cn.cxh.util.Page;

import java.sql.SQLException;
import java.util.List;

public interface NewsService {
    List<News> getNewsList() throws SQLException; //获取新闻列表
    List<News> getPageNews(Page page) throws SQLException;//分页服务
    News getNewsById(int id) throws SQLException;//根据id查询
    boolean updateNews(News news);//更新数据
    boolean saveNews(News news); //保存新闻
    boolean delNewsById(int id) throws SQLException;//删除新闻
    int countNews() throws SQLException;
    List<News> getTopicNews(int tid) throws SQLException;//根据栏目id获取
}
