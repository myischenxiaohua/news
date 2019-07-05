package cn.cxh.service.impl;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service.impl
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 15:05
*/

import cn.cxh.dao.TopicDao;
import cn.cxh.dao.impl.TopicDaoImpl;
import cn.cxh.entity.Topic;
import cn.cxh.service.TopicService;
import cn.cxh.util.DatabaseUtil;

import java.sql.SQLException;
import java.util.List;

public class TopicServiceImpl implements TopicService {
   private DatabaseUtil mysql=null;
    private TopicDao topicDao=null;
    @Override
    public List<Topic> getTopicList() throws SQLException {
        mysql=new DatabaseUtil();
        topicDao=new TopicDaoImpl(mysql.getConn());
        try {
            return topicDao.fiandAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw  e;
        }finally {
            mysql.close();
        }
    }

    @Override
    public boolean saveTopic(Topic topic) {
        mysql=new DatabaseUtil();
        topicDao=new TopicDaoImpl(mysql.getConn());
        boolean flg=false;
        try {
            flg=topicDao.add(topic)>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.close();
        }
        return flg;
    }
}