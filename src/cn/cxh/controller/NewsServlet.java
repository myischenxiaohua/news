package cn.cxh.controller;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.controller
  User: myischenxiaohua@163.com
  Date: 2019/7/1
  Time: 11:41
*/

import cn.cxh.entity.News;
import cn.cxh.service.impl.NewsServiceImpl;
import cn.cxh.service.impl.TopicServiceImpl;
import cn.cxh.util.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewsServlet extends BaseController {
    public void list(HttpServletRequest  request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int pageIndex=request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));

        if (pageIndex<1)
            pageIndex=1;
        Page pageData=new Page();
        pageData.setCurrPageNo(pageIndex);
        pageData.setPageSize(5);
        pageData.setTotalCount(new NewsServiceImpl().countNews());
        request.setAttribute("list",new NewsServiceImpl().getPageNews(pageData));
        request.setAttribute("pageData",pageData);
        request.getRequestDispatcher("/view/admin/index.jsp").forward(request,response);
    }

    public void  add(HttpServletRequest  request, HttpServletResponse response) throws SQLException, ServletException, IOException {
       request.setAttribute("topic",new TopicServiceImpl().getTopicList());
       request.getRequestDispatcher("/view/admin/news/add.jsp").forward(request,response);
    }

    public  void edit(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        int tid=Integer.parseInt(request.getParameter("tid")); //获取修改的新闻id
        request.setAttribute("id",tid);
        request.setAttribute("news",new NewsServiceImpl().getNewsById(tid));
        request.setAttribute("topic",new TopicServiceImpl().getTopicList());
        request.getRequestDispatcher("/view/admin/news/edit.jsp").forward(request,response);

    }

    public void save(HttpServletRequest request,HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("utf-8");
//    int tid=request.getParameter("tid")!=null?Integer.parseInt(request.getParameter("tid")):0;
//    int ntid=Integer.parseInt(request.getParameter("ntid"));
//    String ntitle=request.getParameter("ntitle");
//    String nauthor=request.getParameter("nauthor");
//    String nsummary=request.getParameter("nsummary");
//    String ncontent=request.getParameter("ncontent");
        News news =new News();
//    news.setNtid(ntid);
//    news.setNtitle(ntitle);
//    news.setNauthor(nauthor);
//    news.setNsummary(nsummary);
//    news.setNcontent(ncontent);

        boolean isMultipart= ServletFileUpload.isMultipartContent(request);//判断是不是文件流
        String savePath=getServletConfig().getServletContext().getRealPath("upload");
        String filedName=null;
        PrintWriter pw=response.getWriter();
        if(isMultipart){
            try {


                FileItemFactory fileItemFactory=new DiskFileItemFactory(); //通过实现类创建fileItem工厂对象
                ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
                servletFileUpload.setSizeMax(1024*1024*5);//设置文件上传大小50k
                List<FileItem> fileItemList= servletFileUpload.parseRequest(request);
                Iterator<FileItem> iterator=fileItemList.iterator();
                FileItem fileItem=null;
                File saveFile=null;
                boolean isUploadType=false;//是否允许上传的文件类型
                while (iterator.hasNext()){
                    fileItem= iterator.next();
                    if(fileItem.isFormField()){ //是普通表单

                        filedName=fileItem.getFieldName(); //获取表单name的值
                        switch (filedName){
                            case "tid":news.setNid(Integer.parseInt(fileItem
                                    .getString("UTF-8")));break;
                            case "ntid":news.setNtid(Integer.parseInt(fileItem
                                    .getString("UTF-8")));break;
                            case "ntitle":news.setNtitle(fileItem.getString("UTF-8"));break;

                            case "nauthor":news.setNauthor(fileItem.getString("UTF-8"));break;
                            case "nsummary":news.setNsummary(fileItem.getString("UTF-8"));break;
                            case "ncontent" : news.setNcontent(fileItem.getString("UTF-8"));break;

                        }

                    }else { //文件类

                        String fileName=fileItem.getName();
                        if(fileName.length()>0){ //文件名存在

                            List<String> fileType= Arrays.asList("jpg","png","gif");//设置可上传类型
                            int index=fileName.lastIndexOf("."); //查找文件名中最后一个.的位置
                            String ext=index==-1?"":fileName.substring(index+1).toLowerCase();
                            if(fileType.contains(ext)){ //判断文件是否是上传类
                                String name=String .valueOf(new Date().getTime())+(int)Math.random()*5+"."+ext;
                                saveFile=new File(savePath,name);
                                System.out.println(savePath);
                                fileItem.write(saveFile);
                                news.setNpicpath(name);
                            }else {
                                pw.print("<script type=\"text/javascript\">");
                                pw.print("alert(\"图片上传失败，文件类型只能是gif、jpg、jpeg\");");
                                pw.print("</script>");
                            }



                        }
                    }
                }

            }catch (FileUploadBase.FileSizeLimitExceededException e){
                pw.print("<script type=\"text/javascript\">");
                pw.print("alert(\"图片上传失败，文件的最大限制是：5M\");");
                pw.print("</script>");
            }


        }








        System.out.println("nid:"+news.getNid());

        if(news.getNid()>0){
            news.setNmodifydate(new Date());
            if (!new NewsServiceImpl().updateNews(news)) {
                request.setAttribute("msg","更新失败");
                request.getRequestDispatcher("/view/msg.jsp").forward(request,response);
            }

            //更新
        }else {
            news.setNcreatedate(new Date());
            if(!new NewsServiceImpl().saveNews(news)){
                request.setAttribute("msg","保存失败");
                request.getRequestDispatcher("/view/msg.jsp").forward(request,response);
            }
            //newsDao.insertNews(news);

            //保存
        }

        response.sendRedirect(request.getContextPath()+"/new.html?action=list");

    }

//    删除
    public void del(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {

        int nid=Integer.parseInt(request.getParameter("nid"));
        if (new NewsServiceImpl().delNewsById(nid)){
            response.sendRedirect(request.getContextPath()+"/new.html?action=list");
        }else {
            request.setAttribute("msg","删除失败");
            request.getRequestDispatcher(request.getContextPath()+"/view/msg.jsp");
        }

    }

    public void  show(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        int tid=Integer.parseInt(request.getParameter("tid"));
        request.setAttribute("news",new NewsServiceImpl().getNewsById(tid));
        request.setAttribute("topics",new TopicServiceImpl().getTopicList());
        request.getRequestDispatcher("/view/admin/news/show.jsp").forward(request,response);

    }



}
