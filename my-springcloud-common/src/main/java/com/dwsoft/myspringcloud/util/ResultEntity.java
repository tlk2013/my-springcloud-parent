package com.dwsoft.myspringcloud.util;

/**
 * 统一格式响应工具类
 * @author tlk
 * @date 2020/7/14-17:01
 */
public class ResultEntity<T> {
    private static final  String SUCCESS="SUCCESS";//成功
    private static final  String FAILED="FAILED";//失败
    private String  result;
    private String  message;
    private T  data;

    /**
     * 操作成功  不需要携带返回数据
     * @return
     */
    public static ResultEntity<String> successWithoutData(){


        return new ResultEntity<String>(SUCCESS,null,null);
    }

    /**
     * 操作成功需要携带返回数据
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> successWithData(E data){


        return new ResultEntity<E>(SUCCESS,null,data);
    }

    /**
     * 操作失败
     * @param message
     * @return
     */
    public static <E>ResultEntity<E> failed(String message){


        return new ResultEntity<E>(FAILED,message,null);
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultEntity() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
