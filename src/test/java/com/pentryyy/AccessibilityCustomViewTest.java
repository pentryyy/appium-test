package com.pentryyy;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pentryyy.driver.DriverSetup;

public class AccessibilityCustomViewTest extends DriverSetup {
   
    @Disabled
    @Test
    public void testCustomViewAccessibility() {
        // Ожидаем главный экран
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        // Шаг 1: Переход в Accessibility
        WebElement accessibilityMenu = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Accessibility']")
            )
        );
        accessibilityMenu.click();
        
        // Шаг 2: Переход в Custom View
        WebElement customViewOption = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Custom View']")
            )
        );
        customViewOption.click();
        
        // Шаг 3: Проверка элементов на экране
        WebElement talkbackInstruction = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("com.example.android.apis:id/instructions")
            )
        );
        
        // Проверка отображения инструкций
        assert talkbackInstruction.getText().contains("Enable TalkBack");
        assert talkbackInstruction.getText().contains("Enable Explore-by-Touch");
        
        // Дополнительная проверка заголовка
        WebElement screenTitle = driver.findElement(By.className("android.widget.TextView"));
        assert screenTitle.getText().equals("Accessibility/Custom View");
    }
}
