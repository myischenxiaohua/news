package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/1
  Time: 9:22
*/

import cn.cxh.entity.User;
import cn.cxh.service.UserService;
import cn.cxh.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class UserServlet extends BaseController {


    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName=request.getParameter("user");
        String uPwd=request.getParameter("pwd");
        UserService userService=new UserServiceImpl();
        User user=new User();
        user.setuName(uName);
        user.setuPwd(uPwd);
        if(userService.addUser(user)){
            request.setAttribute("msg","注册成功！");
        }else {
            request.setAttribute("msg","注册失败！");
        }

        request.getRequestDispatcher("/msg.jsp").forward(request,response); //转发请求 forward方法把请求信息和响应信息传过去
    }


    public void cheackUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
      //  response.setHeader("Access-Control-Allow-Origin", "*");
        String name=request.getParameter("uName");
        User user=new User();
        user.setuName(name);
        boolean flag=false;
        String msg="恭喜可以注册";
        PrintWriter pw=response.getWriter();
        StringBuffer stringBuffer=new StringBuffer();

       if(new UserServiceImpl().getUser(user).getId()>0){
          flag=true;
          msg="该用户已存在";
       }

       Map map=new HashMap();
       map.put("status",flag);
       map.put("msg",msg);


//        stringBuffer.append("{");
//        stringBuffer.append("\"status\":"+flag+",");
//        stringBuffer.append("\"msg\":"+"\""+msg+"\"");
//        stringBuffer.append("}");

        pw.print( JSONArray.toJSONString(map));
    }

    public void  show(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("us","张珊");
        try {
            request.getRequestDispatcher("/view/msg.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
