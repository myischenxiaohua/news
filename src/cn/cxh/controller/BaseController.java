package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/1
  Time: 10:14
*/

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
       
        System.out.println(getClass());
        System.out.println(HttpServletRequest.class);
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String action=request.getParameter("action");
        Method method=null;

            //获取执行的方法
        try {
            method= getClass().getDeclaredMethod(action,HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
