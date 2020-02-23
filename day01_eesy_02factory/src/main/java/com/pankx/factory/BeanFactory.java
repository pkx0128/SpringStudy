package com.pankx.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    static Properties properties;
    static Map<String,Object> beans = null;
    static {

        try {
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            beans = new HashMap<String, Object>();
            properties.load(in);
            Enumeration keys =properties.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String path = properties.getProperty(key).toString();
                Object object = Class.forName(path).newInstance();
                beans.put(key,object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName){
//            Object object = null;
//            String path = properties.getProperty(beanName);
//            System.out.println(path);
//            try {
//                object = Class.forName(path).newInstance();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            }
//            return object;
//
//
//        }
}
