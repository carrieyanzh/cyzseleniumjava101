package org.lambdatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumPlaygroundMainPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public SeleniumPlaygroundMainPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  private final By simpleFormDemoLink = By.linkText("Simple Form Demo");
  private final By dragDropSliderLink = By.linkText("Drag & Drop Sliders");
  private final By inputFormSubmitLink = By.linkText("Input Form Submit");

  public void open() {
    driver.get("https://www.lambdatest.com/selenium-playground/");
  }

  //Test Scenario 1:
  public void openSimpleFormDemo() {
    //driver.findElement(simpleFormDemoLink).click();
    wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemoLink)).click();
  }

  //Test Scenario 2:
  public void openDragDropSliders() {
    //driver.findElement(dragDropSliderLink).click();
    wait.until(ExpectedConditions.elementToBeClickable(dragDropSliderLink)).click();
  }

  //Test Scenario 3:
  public void openInputFormSubmit() {
    //driver.findElement(inputFormSubmitLink).click();
    wait.until(ExpectedConditions.elementToBeClickable(inputFormSubmitLink)).click();
  }
}
