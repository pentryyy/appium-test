package com.pentryyy.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSetup {
   
    protected static AndroidDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            .setDeviceName("Android")
            .setAppPackage("com.android.settings")
            .setAppActivity(".Settings")
            .setLanguage("en")
            .setLocale("US")
            .setAutoGrantPermissions(true);

        driver = new AndroidDriver(
            URI.create("http://localhost:4723").toURL(),
            options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
