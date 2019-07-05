package cn.cxh.dao;

import cn.cxh.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao {
    List<Topic> fiandAll() throws SQLException; //查询所有
    Topic findById(int id);//根据id查询
    int add(Topic topic) throws SQLException; //添加
    int update(Topic topic);//更新
    int del(int id);//根据id删除
}
