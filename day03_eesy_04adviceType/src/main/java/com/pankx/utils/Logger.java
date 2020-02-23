package com.pankx.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类(通知类)，里面提供公共的代码
 */
public class Logger {
    /**
     * 用于记录日志，计划让其在切入点方法执行之前执行（切入点方法为就是业务层中的方法）
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("================================");
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记日志了。。。。。");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrowPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowPrintLog方法开始记录日志....");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。。。");
    }

    /**
     * 环绕通知
     * 出现的问题:
     *      当我们配置了环绕通知后，切入点方法没有执行，通知方法却执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知中有明确的切入点方法调用，而我们的代码没有
     * 解决：
     *      spring框架为我们提供了一个接口：proceedingJoinPoint.该接口有一个方法Proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供接口的实现类我们使用。
     *
     * spring中的环绕通知：是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     *
     */
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//获取方法执行所需要的参数
            System.out.println("环绕通知Logger类中的aroundPringLog方法开始记录日志了。。。。。前置通知");
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
            System.out.println("环绕通知Logger类中的aroundPringLog方法开始记录日志了。。。。。后置通知");
        } catch (Throwable throwable) {
            System.out.println("环绕通知Logger类中的aroundPringLog方法开始记录日志了。。。。。异常通知");
            throwable.printStackTrace();
        }finally{
            System.out.println("环绕通知Logger类中的aroundPringLog方法开始记录日志了。。。。。最终通知");
        }
        return rtValue;
    }
}
