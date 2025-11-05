package org.lambdatest.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputFormSubmitScreen {
  private WebDriver driver;
  private final WebDriverWait wait;

  private final By name = By.id("name");
  private final By email = By.id("inputEmail4");
  private final By password = By.id("inputPassword4");
  private final By company = By.id("company");
  private final By website = By.id("websitename");
  private final By country = By.name("country");
  private final By city = By.id("inputCity");
  private final By addressLine1 = By.name("address_line1");
  private final By addressLine2 = By.name("address_line2");
  private final By state = By.id("inputState");
  private final By zip = By.id("inputZip");

  public InputFormSubmitScreen(final WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  private void countryName(final String countryName) {
    this.driver.findElement(country).click();
    new Select(this.driver.findElement(country)).selectByVisibleText(countryName);
  }

  public WebElement submitBtn() {
    return this.driver.findElement(By.cssSelector("#seleniumform button[type=\"submit\"]"));
  }

  public String successMessage() {
    return this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.success-msg"))).getText();
  }

  public String getValidationMessage() {
    return driver.findElement(name).getAttribute("validationMessage");
  }

  public boolean isSuccessMessageDisplayed() {
    try {
      String messageText = successMessage();
      return messageText.contains("Thanks for contacting us");
    } catch (TimeoutException e) {
      return false;
    }
  }

  public void fillForm(final String name, final String email, final String password,
                       final String company,final String website,
                       final String country, final String city,
                       final String addressLineOne, final String addressLineTwo,
                       final String state, final String zipCode
                           ) {
    this.driver.findElement(this.name).sendKeys(name);
    this.driver.findElement(this.email).sendKeys(email);
    this.driver.findElement(this.password).sendKeys(password);
    this.driver.findElement(this.company).sendKeys(company);
    this.driver.findElement(this.website).sendKeys(website);
    this.countryName(country);
    this.driver.findElement(this.city).sendKeys(city);
    this.driver.findElement(this.addressLine1).sendKeys(addressLineOne);
    this.driver.findElement(this.addressLine2).sendKeys(addressLineTwo);
    this.driver.findElement(this.state).sendKeys(state);
    this.driver.findElement(this.zip).sendKeys(zipCode);
  }
}
