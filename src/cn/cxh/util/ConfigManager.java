package cn.cxh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件，将mysql.properties 转换成文件流加载到属性对象，任何使用属性对象读取属性文件的值，根据键名。
public class ConfigManager {
    private static Properties properties=null;
    static {
        InputStream inputStream=null; //声明一个输入流
      inputStream=  ConfigManager.class.getClassLoader().getResourceAsStream("mysql.properties");

      if(inputStream==null){
          throw new RuntimeException("数据库配置文件不存在");
      }
        properties=new Properties();//实例化属性对象
        try {
            properties.load(inputStream); //把文件流加载到属性对象里面

        } catch (IOException e) {
            throw  new RuntimeException("加载配置文件流失败");
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //通过键值获取属性文件中的值
    public static String getProperties(String key){
        return properties.getProperty(key);
    }

}
