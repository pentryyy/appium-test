package com.pentryyy.utils;

public class DirectoryUtils {
    private static final String RESOURCES_DIR = "src/test/resources/";

    public static String getApkPath(String apkName) {
        return RESOURCES_DIR + "app/" + apkName + ".apk";
    }
}
