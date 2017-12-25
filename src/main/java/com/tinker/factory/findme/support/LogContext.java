package com.tinker.factory.findme.support;

/**
 *Created by hans_h'bravo on 24/12/2017
 */
public class LogContext {

    private static ThreadLocal<String> localUserId = new ThreadLocal<String>();


    public static String getUserId() {
        return localUserId.get();
    }

    public static String getUserIdSafe() {
        String userId = LogContext.getUserId();

        if (userId != null && userId.isEmpty()) {
            return "no-active-user";
        }
        return userId==null? "cron-usr":userId;
    }

    public static void setUserId(String userId) {
        localUserId.set(userId);
    }

    public static void cleanup() {
        localUserId.remove();
    }
}
