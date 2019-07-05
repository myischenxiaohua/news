package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/4
  Time: 9:18
*/

import cn.cxh.entity.User;
import cn.cxh.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginServlet extends BaseController {

    //登陆
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uName=request.getParameter("uName");
        String uPwd=request.getParameter("uPwd");

        User user=new User();
        user.setuName(uName);
        user.setuPwd(uPwd);
        Map msgMap=new HashMap();
        user=new UserServiceImpl().getUser(user);
        if (user.getId()>0&&user.getuPwd().equals(uPwd)){
            request.getSession().setAttribute("user",user);//登陆成功设置登陆session
            //用户存在
            msgMap.put("msg","登陆成功");
            msgMap.put("status",true);
            msgMap.put("user",user.getuName());
           if(Objects.isNull(getServletContext().getAttribute("loginCount"))) {
               getServletContext().setAttribute("loginCount",1);
           }else {
               Integer count=(Integer) getServletContext().getAttribute("loginCount");
               getServletContext().setAttribute("loginCount",count+1);
           }



        }else {
            msgMap.put("msg","登陆失败，用户名或密码错误");
            msgMap.put("status",false);
        }

        PrintWriter pw =response.getWriter();
        pw.print(JSONArray.toJSONString(msgMap));


    }

//    注销
    public void loginout(HttpServletRequest request,HttpServletResponse response) throws IOException {

        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/view/login.jsp");
      Integer count=(Integer)getServletContext().getAttribute("loginCount");
        getServletContext().setAttribute("loginCount",count-1);

    }
}
