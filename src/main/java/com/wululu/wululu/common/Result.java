package com.wululu.wululu.common;

public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 构造方法、getter和setter省略

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功响应的静态方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    // 失败响应的静态方法
    public static <T> Result<T> failure(String message) {
        return new Result<>(500, message, null);
    }

    // 其他业务状态码的静态方法可以继续添加
}