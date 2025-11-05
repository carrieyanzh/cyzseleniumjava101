package org.lambdatest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DragDropSlidersScreen {
  private WebDriver driver;

  private final By slidertwo = By.cssSelector("input[type='range'][value='15']");
  private final By outputRange = By.cssSelector("output#rangeSuccess");

  public DragDropSlidersScreen(WebDriver driver) {
    this.driver = driver;
  }

  public void dragSliderTo(int targetValue) {
    int offset = calculateOffsetForValue(targetValue);
    final Actions actions = new Actions(this.driver);
    actions.moveToElement(this.driver.findElement(slidertwo))
      .clickAndHold()
      .moveByOffset(offset, 0)
      .release()
      .build()
      .perform();
  }

  public boolean isSliderValue(int expected) {
    String value = this.driver.findElement(outputRange).getText();
    return value.equals(String.valueOf(expected));
  }

  public int calculateOffsetForValue(int targetValue) {
    // Known data points: (offset, value)
    double offset1 = 100, value1 = 71;
    double offset2 = 220, value2 = 96;

    // Calculate slope (m)
    double m = (value2 - value1) / (offset2 - offset1);

    // Calculate intercept (b)
    double b = value1 - (m * offset1);

    // Calculate offset for target value
    double calculatedOffset = (targetValue - b) / m;
    return (int) Math.round(calculatedOffset);
  }
}
