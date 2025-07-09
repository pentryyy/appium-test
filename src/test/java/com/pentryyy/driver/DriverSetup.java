package com.pentryyy.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.pentryyy.utils.DirectoryUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSetup {
   
    protected static AndroidDriver driver;

    private static Properties props;

    @BeforeAll
    public static void setUp() throws FileNotFoundException, IOException {
        props = new Properties();
        props.load(new FileInputStream(DirectoryUtils.getConfigPath("config")));

        UiAutomator2Options options = new UiAutomator2Options()
            .setPlatformName(props.getProperty("platformName"))
            .setAutomationName(props.getProperty("automationName"))
            .setDeviceName(props.getProperty("deviceName"))
            .setNoReset(true)
            .setLanguage("en")
            .setLocale("US")
            .setAutoGrantPermissions(true);

        driver = new AndroidDriver(
            URI.create("http://localhost:4723").toURL(),
            options
        );

        driver.installApp(
            DirectoryUtils.getApkPath(props.getProperty("appName")), 
            new AndroidInstallApplicationOptions().withReplaceEnabled()
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {

            if (driver.isAppInstalled(props.getProperty("appPackageName")))
                driver.removeApp(props.getProperty("appPackageName"));

            driver.quit();
        }
    }
}
