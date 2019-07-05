package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/3
  Time: 10:08
*/

import cn.cxh.entity.Topic;
import cn.cxh.service.TopicService;
import cn.cxh.service.impl.TopicServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TopicServlet extends BaseController {
    private TopicService topicService=new TopicServiceImpl();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/topic/add.jsp").forward(request,response);
    }

    public void save(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
                String tname= request.getParameter("tname");
               // 获取请求的参数

                Topic topic=new Topic();
                topic.setTname(tname);
                //调用服务层 保存的服务
                if(topicService.saveTopic(topic)){
                    //添加成功,请求栏目列表的servlet list方法转发到jsp
                    response.sendRedirect(request.getContextPath()+"/topic.html?action=list");

                }else {

                    request.setAttribute("msg","保存失败！");
                    request.getRequestDispatcher("/view/tips.jsp").forward(request,response);

                }

    }

    public void list(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
       request.setAttribute("topics",topicService.getTopicList());
       System.out.println("topics");
       request.getRequestDispatcher("/view/admin/topic/list.jsp").forward(request,response);

    }

    public void ajaxList(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {

        PrintWriter pw=response.getWriter();
        pw.print( JSONArray.toJSONString(topicService.getTopicList())); //把list集合转出json数组
       // JSONObject.toJSON()  将java对象转换成json对象

    }

    public  void  loadList(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        StringBuffer stringBuffer=new StringBuffer("");
        for (Topic topic:topicService.getTopicList()) {
                stringBuffer.append("<li> &nbsp;&nbsp;&nbsp;&nbsp; "+topic.getTname()+"&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"../newspages/topic_modify.jsp?tid="+topic.getTname()+"&amp;tname="+topic.getTname()+"\">修改</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"../util/topics?opr=del&amp;tid="+topic.getTid()+"\">删除</a> </li>");
        }
        response.getWriter().print(stringBuffer);
    }

}
