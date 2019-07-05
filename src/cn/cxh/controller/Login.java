package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/6/29
  Time: 14:34
*/

import cn.cxh.dao.impl.UserDaoImpl;
import cn.cxh.entity.User;
import cn.cxh.service.UserService;
import cn.cxh.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String methed=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
            switch (methed){
                case "login":userLogin(request,response);break;
            }

    }

    public  void userLogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            System.out.println("userLogin");

        request.setCharacterEncoding("utf-8");
        String user= request.getParameter("user");
        String pwd= request.getParameter("pwd");
        String auto=request.getParameter("autoLogin");
        if(auto!=null){
            System.out.print("点了自动登录");
            Cookie cookieUser=new Cookie("user",user);
            Cookie cookiePwd=new Cookie("pwd",pwd);
            cookiePwd.setMaxAge(300);
            response.addCookie(cookieUser);
            response.addCookie(cookiePwd);

            Cookie[] cookies=request.getCookies();
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("user")){
                    user=cookie.getValue();
                }
                if (cookie.getName().equals("pwd")){
                    pwd=cookie.getValue();
                }
            }

        }



        int role=0;
        UserService userService=new UserServiceImpl();

        User loginUser=new User();
        loginUser.setuName(user);
        loginUser.setuPwd(pwd);
        loginUser= userService.getUser(loginUser);
        System.out.println(loginUser.getuName());
        System.out.println(loginUser.getuPwd());

        if(loginUser.getuName().equals(user)&&loginUser.getuPwd().equals(pwd)){
            request.getSession().setAttribute("user",user);
            if(role==0){


//                if(Objects.nonNull(this.getServletContext().getAttribute("size"))){
//
//                    int size=(int)this.getServletContext().getAttribute("size");
//                    System.out.println(size);
//                   this.getServletContext().setAttribute("size",size+1);
//                }else {
//                   this.getServletContext().setAttribute("size",1);
//                }
                response.sendRedirect("/view/admin/index.jsp");
                // request.getRequestDispatcher("/view/admin/index.jsp").forward(request,response);
            }else {
                response.sendRedirect("/new/index.jsp");
            }

        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/view/login.jsp").forward(request,response);
        }


        PrintWriter pw=response.getWriter();
        pw.println("执行了doPost");
    }


    public  void exit(HttpServletRequest request,HttpServletResponse response){
        System.out.println("exit");
    }




    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化参数："+servletConfig.getInitParameter("zs"));
       System.out.println("执行了init");



    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //
       // request.setCharacterEncoding("utf-8");
        System.out.println("执行了service");
        super.service(request,response);
    }

    @Override
    public ServletConfig getServletConfig() {

        return super.getServletConfig();


    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }

    public void dis(String str){
        System.out.println("dis方法执行:"+str);
    }
}
