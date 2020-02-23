package com.pankx.utils;

/**
 * 用于记录日志的工具类，里面提供公共的代码
 */
public class Logger {
    /**
     * 用于记录日志，计划让其在切入点方法执行之前执行（切入点方法为就是业务层中的方法）
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记日志了。。。。。");
    }
}
