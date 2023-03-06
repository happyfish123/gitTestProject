package com.example.demo.common;

/**
 * 系统级返回状态码规范
 */
public enum ResponseStatus {

    SUCCESS("200", "操作成功"),
    BAD_REQUEST("400", "请求异常"),
    UNAUTHORIZED("401", "需要身份认证"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "找不到资源"),
    SERVER_EXCEPTION("500", "系统内部异常"),
    BAD_GATEWAY("502", "错误网关"),
    SERVICE_UNAVAILABLE("503", "服务暂时不可用"),
    GATEWAY_TIMEOUT("504", "网关超时"),
    FAIL("900", "操作失败"),
    NO_CONTENT("901", "无内容"),
    EXIST("902", "已经存在"),
    VERIFICATION_FAIL("903", "校验不通过"),
    INVALID_PARAM("904", "非法参数"),
    NULL_POINT_PARAM("905", "空指针异常");

    private final String code;
    private final String message;

    ResponseStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
