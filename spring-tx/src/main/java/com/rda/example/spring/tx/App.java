package com.rda.example.spring.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lianrao on 2015/8/6.
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TxService txService = (TxService) context.getBean("txService");
//        txService.invokeRequireNewTransMethodInSameClass();
//        txService.invokeRequireNewTransMethodInAnotherService();
//        txService.getNotCommitDataInTheSameTransaction();
//        txService.invokeRequireNewTransMethodInAnotherService();
//        txService.getNotCommitDataInTheSameTransaction();
//        txService.rollbackOnCheckedException();
        txService.noTransAnnotation();
//        txService.commitOnCheckedException();

//        txService.invokeRequireNewTransMethodInAnotherService();

//        Thread.currentThread().suspend();
//        txService.normalCommit();
//        txService.throwExceptionInMethod();
    }
}
