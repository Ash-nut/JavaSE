package cn.helloworld1999.util;

import java.util.Date;
import java.util.UUID;

/**
 * IDUtil
 */
public class IDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}