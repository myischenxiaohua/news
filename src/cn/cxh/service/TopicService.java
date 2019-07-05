package cn.cxh.service;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.service.impl
  User: myischenxiaohua@163.com
  Date: 2019/6/27
  Time: 9:50
*/

import cn.cxh.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    List<Topic> getTopicList() throws SQLException;//获取所有主题
    boolean saveTopic(Topic topic); //保存主题

}
