package cn.hacklike.common;

import java.io.Serializable;

public class Response<T> implements Serializable {


    private static final long serialVersionUID = 7401356867818606822L;

    private boolean success = true;

    private String msg = "请求成功";

    private T data;

    private Object exception;

    public static <T> Response<T> newInstance() {
        return new Response<T>();
    }

    public static <T> Response<T> newInstance(T data) {
        return init(data, true, null, null);
    }

    public static <T> Response<T> newInstance(T data, boolean success) {
        return init(data, success, null, null);
    }

    public static <T> Response<T> newInstance(T data, String msg) {
        return init(data, true, msg, null);
    }

    public static <T> Response<T> newInstance(T data, boolean success, String msg) {
        return init(data, success, msg, null);
    }

    public static <T> Response<T> newInstance(T data, boolean success, String msg, Object exception) {
        return init(data, success, msg, exception);
    }

    public static <T> Response<T> newErrorInstance(String msg, Object exception) {
        return init(null, false, msg, exception);
    }

    public static <T> Response<T> newErrorInstance(Object exception) {
        return init(null, false, "后台接口错误", exception);
    }

    public static <T> Response<T> newInstance(T data, boolean success, String msg, Exception exception) {
        return init(data, success, msg, exception);
    }

    public static <T> Response<T> newErrorInstance(String msg, Exception exception) {
        return init(null, false, msg, exception);
    }

    public static <T> Response<T> newErrorInstance(Exception exception) {
        return init(null, false, "后台接口错误", exception);
    }

    private static <T> Response<T> init(T data, boolean success, String msg, Object exception) {
        Response<T> response = new Response<>();
        if (null != data) {
            response.setData(data);
        }
        response.setSuccess(success);
        if (null != msg) {
            response.setMsg(msg);
        }
        if (null != exception) {
            if (exception instanceof Exception) {
                response.setException(((Exception) exception).getMessage());
            } else {
                response.setException(exception);
            }
        }
        return response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

}