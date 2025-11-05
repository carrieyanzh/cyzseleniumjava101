package org.lambdatest.tests;

import org.lambdatest.BaseTest;
import org.lambdatest.helper.JSONReader;
import org.lambdatest.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;

public class PlaygroundAssignTests extends BaseTest {
  @DataProvider(name = "jsonFormData")
  public Object[][] provideJSONFormData() {
    return JSONReader.readJSON("src/test/resources/testdata.json");
  }

  @Test(timeOut = 20000)
  public void testSimpleFormDemo() {
    SeleniumPlaygroundMainPage playground = new SeleniumPlaygroundMainPage(getDriver());
    playground.open();
    playground.openSimpleFormDemo();

    SimpleFormDemoScreen simpleForm = new SimpleFormDemoScreen(getDriver());
    Assert.assertTrue(simpleForm.isUrlCorrect(), "URL does not contain 'simple-form-demo'");

    String message = "Welcome to LambdaTest";
    simpleForm.enterMessage(message);
    simpleForm.clickGetCheckedValue();
    Assert.assertEquals(simpleForm.getDisplayedMessage(), message, "Message text mismatch");
  }

  @Test(timeOut = 20000)
  public void testDragDropSlider() {
    SeleniumPlaygroundMainPage playground = new SeleniumPlaygroundMainPage(getDriver());
    playground.open();
    playground.openDragDropSliders();

    DragDropSlidersScreen sliderPage = new DragDropSlidersScreen(getDriver());
    sliderPage.dragSliderTo(95);
    Assert.assertTrue(sliderPage.isSliderValue(95), "Slider not set to 95");
  }

  @Test(dataProvider = "jsonFormData", timeOut = 20000)
  public void testInputFormSubmitWithJSON(Map<String, String> testData) {
    SeleniumPlaygroundMainPage playground = new SeleniumPlaygroundMainPage(getDriver());
    playground.open();
    playground.openInputFormSubmit();

    InputFormSubmitScreen formPage = new InputFormSubmitScreen(getDriver());

    // Step 1: Try to submit empty form
    formPage.submitBtn().click();

    // Step 2: Validate validation message
    String validationMsg = formPage.getValidationMessage();
    Assert.assertTrue(validationMsg.contains("fill out this field"),
      "Expected validation message not found. Actual: " + validationMsg);

    // Step 3: Fill form with data from JSON
    formPage.fillForm(
      testData.get("name"),
      testData.get("email"),
      testData.get("password"),
      testData.get("company"),
      testData.get("website"),
      testData.get("country"),
      testData.get("city"),
      testData.get("address1"),
      testData.get("address2"),
      testData.get("state"),
      testData.get("zip")
    );
    formPage.submitBtn().click();

    // Validate success message
    String msg = formPage.successMessage();
    Assert.assertTrue(formPage.isSuccessMessageDisplayed(),
      "Success message not displayed for test data: " + testData.get("name"));
  }
}
