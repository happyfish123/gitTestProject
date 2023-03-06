package com.example.demo.common;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class Assert {

    private static Function<String, ? extends RuntimeException> ERROR_BUILD_CONSUMER;

    static {
        setErrorCreate(RuntimeException::new);
    }

    public synchronized static void setErrorCreate(Function<String, ? extends RuntimeException> function) {
        ERROR_BUILD_CONSUMER = function;
    }

    private static void throwException(String message) {
        throw ERROR_BUILD_CONSUMER.apply(message);
    }

    /**
     * 不为null
     * */
    public static void nonNull(Object obj, String message) {
        if (obj == null) {
            throwException(message);
        }
    }

    /**
     * 不为null或者空字符串
     * */
    public static void nonNullStr(String obj, String message) {
        if (obj == null || "".equals(obj)) {
            throwException(message);
        }
    }

    /**
     * 是否为true
     * */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throwException(message);
        }
    }

    /**
     * 是否为false
     * */
    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throwException(message);
        }
    }

    /**
     * 集合不为空
     * */
    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.size() == 0) {
            throwException(message);
        }
    }


    /**
     * map不为空
     * */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throwException(message);
        }
    }

    /**
     * 只能为英文和数字
     * */
    public static void isLetterDigit(String str, String message) {
        String regex = "^[a-z0-9A-Z]+$";
        if(!str.matches(regex)) {
            throwException(message);
        }
    }

    /**
     * 字段名称只能为英文
     * */
    public static void isLetter(String str, String message) {
        String regex = "^[a-zA-Z]+$";
        if(!str.matches(regex)) {
            throwException(message);
        }
    }



}
