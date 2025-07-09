package com.pentryyy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.pentryyy.driver.DriverSetup;

public class AndroidTests extends DriverSetup {

    @Test
    public void testFindBattery() {
        driver.findElement(By.xpath("//*[@text='Battery']")).click();
    }
}
