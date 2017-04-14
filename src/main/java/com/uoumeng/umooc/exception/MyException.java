package com.uoumeng.umooc.exception;

/**
 * Created by chenjun on 2017/4/14.
 * 定义一种统一的异常，先全部处理了。
 * 项目结束再把异常细分。
 */
public class MyException extends RuntimeException{
    public MyException(String msg){
        super(msg);
    }

    public MyException(String msg,Throwable cause){
        super(msg,cause);
    }
}
