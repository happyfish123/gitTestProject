package com.example.demo.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").substring(0, 16);
    }

}
