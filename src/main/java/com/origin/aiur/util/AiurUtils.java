package com.origin.aiur.util;

public class AiurUtils {
    public static boolean isEmpty(String value) {
        if (value == null || value.trim().length() <= 0) {
            return true;
        }
        return false;
    }
}
