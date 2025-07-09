package com.pentryyy.utils;

import java.nio.file.Paths;

public class DirectoryUtils {
    private static final String RESOURCES_DIR = "src/test/resources/";

    public static String getApkPath(String apkName) {
        return Paths.get("")
            .toAbsolutePath()
            .resolve(RESOURCES_DIR)
            .resolve("app/")
            .resolve(apkName + ".apk")
            .normalize()
            .toString();
    }

    public static String getConfigPath(String configName) {
        return RESOURCES_DIR + configName + ".properties";
    }
}
