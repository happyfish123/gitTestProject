package com.example.demo.common;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回的对象
 */
@Data
public class ResponseEntity<T> implements Serializable {
    private static final long serialVersionUID = 5344252448539477435L;

    private Meta meta;
    private T data = null;

    /**
     * 默认请求成功 200
     *
     * @return ResponseEntity
     */
    public ResponseEntity<T> success() {
        this.setMeta(new Meta(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMessage()));
        return this;
    }

    /**
     * 请求成功 200，返回的信息自定义
     *
     * @param message 自定义成功的消息
     * @return ResponseEntity
     */
    public ResponseEntity<T> success(String message) {
        this.setMeta(new Meta(ResponseStatus.SUCCESS.getCode(), message));
        return this;
    }

    /**
     * 默认请求失败 900
     *
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure() {
        this.setMeta(new Meta(ResponseStatus.FAIL.getCode(), ResponseStatus.FAIL.getMessage()));
        return this;
    }

    /**
     * 请求失败 900，返回的信息自定义
     *
     * @param throwable 堆栈错误信息
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure(Throwable throwable) {
        this.setMeta(new Meta(ResponseStatus.FAIL.getCode(), ResponseStatus.FAIL.getMessage(), Throwables.getStackTraceAsString(throwable)));
        return this;
    }

    /**
     * 请求失败 900，返回的信息自定义
     *
     * @param  message 业务产生的错误信息
     * @param throwable 堆栈错误信息
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure(String message, Throwable throwable) {
        this.setMeta(new Meta(ResponseStatus.FAIL.getCode(), message, Throwables.getStackTraceAsString(throwable)));
        return this;
    }

    /**
     * 自定义信息和状态码
     *
     * @param ResponseStatus ResponseStatus
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure(ResponseStatus ResponseStatus) {
        this.setMeta(new Meta(ResponseStatus.getCode(), ResponseStatus.getMessage()));
        return this;
    }

    /**
     * 自定义信息和状态码
     *
     * @param ResponseStatus ResponseStatus
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure(ResponseStatus ResponseStatus, String stackMessage) {
        this.setMeta(new Meta(ResponseStatus.getCode(), ResponseStatus.getMessage(), stackMessage));
        return this;
    }

    /**
     * 自定义信息和状态码
     *
     * @param code    code
     * @param message message
     * @return ResponseEntity
     */
    public ResponseEntity<T> failure(String code, String message, String stackMessage) {
        this.setMeta(new Meta(code, message, stackMessage));
        return this;
    }

    /**
     * 内部类，把返回数据和返回状态码信息隔离开
     */
    @Data
    public static class Meta implements Serializable {
        private static final long serialVersionUID = -834176698215735155L;

        private String statusCode;

        private String message;

        private String stackMessage;

        Meta(String statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        Meta(String statusCode, String message, String stackMessage) {
            this.statusCode = statusCode;
            this.message = message;
            this.stackMessage = stackMessage;
        }
    }

    /**
     * 将对象转成json字符串
     */
    public String toJsonStr() {
        return JSON.toJSONString(this);
    }
}
