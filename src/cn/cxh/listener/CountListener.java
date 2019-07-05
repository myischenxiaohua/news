package cn.cxh.listener;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.listener
  User: myischenxiaohua@163.com
  Date: 2019/7/4
  Time: 15:36
*/

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class CountListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("监听到conttext里面的属性增加了，属性名："+servletContextAttributeEvent.getName()
        +"属性值："+servletContextAttributeEvent.getValue()
        );

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent atr) {
            //移除属性的时候干什么事
        System.out.println("被移除属性"+atr.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent atr) {
            //修改值
        System.out.println("被修改属性"+atr.getName());
    }
}
