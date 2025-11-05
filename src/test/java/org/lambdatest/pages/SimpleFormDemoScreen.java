package org.lambdatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemoScreen {
  private WebDriver driver;

  public SimpleFormDemoScreen(WebDriver driver) {
    this.driver = driver;
  }

  private final By messageInput = By.id("user-message");
  private final By getCheckedValueButton = By.id("showInput");
  private final By displayedMessage = By.id("message");

  public boolean isUrlCorrect() {
    return driver.getCurrentUrl().contains("simple-form-demo");
  }

  public void enterMessage(String message) {
    driver.findElement(messageInput).clear();
    driver.findElement(messageInput).sendKeys(message);
  }

  public void clickGetCheckedValue() {
    driver.findElement(getCheckedValueButton).click();
  }

  public String getDisplayedMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(displayedMessage)).getText();
  }
}
