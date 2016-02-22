package com.rda.example.spring.tx;

/**
 * Created by lianrao on 2015/8/6.
 */
public class Util {

    public  static void printStackInfo(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for(StackTraceElement e:stackTrace){
            System.out.println(e.toString());
        }
    }
}
