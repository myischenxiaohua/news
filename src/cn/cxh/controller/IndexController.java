package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/1
  Time: 16:14
*/

import cn.cxh.service.impl.NewsServiceImpl;
import cn.cxh.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class IndexController extends BaseController {
    public void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("news", new NewsServiceImpl().getTopicNews(1));
        request.setAttribute("tNews", new NewsServiceImpl().getTopicNews(2));
        request.setAttribute("hNews", new NewsServiceImpl().getTopicNews(5));
        request.setAttribute("topics",new TopicServiceImpl().getTopicList());

        request.getRequestDispatcher("/view/index.jsp").forward(request,response);

    }
}
