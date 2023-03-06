package com.example.demo.util;

import java.util.Base64;

public class Base64Utils {

    /**
     * 加密字符串
     *
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * 解密字符串
     *
     * @param str 需要解密的字符串
     * @return 解密后的字符串
     */
    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }
}
