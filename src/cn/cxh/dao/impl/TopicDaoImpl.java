package cn.cxh.dao.impl;

import cn.cxh.dao.TopicDao;
import cn.cxh.entity.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    public TopicDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Topic> fiandAll() throws SQLException {
        String sql="select * from topic";
        ResultSet rst=super.executeQuery(sql);
        List topicList=new ArrayList();
        while (rst.next()){
           Topic topic=new Topic();
           topic.setTid(rst.getInt("tid"));
           topic.setTname(rst.getString("tname"));
           topicList.add(topic);
        }

        return topicList;
    }

    @Override
    public Topic findById(int id) {
        return null;
    }

    @Override
    public int add(Topic topic) throws SQLException {
        String sql="insert into topic(tname) values(?)";
        return super.executeUpdate(sql,topic.getTname());
    }

    @Override
    public int update(Topic topic) {
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }
}
