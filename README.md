# cyzseleniumjava101
# LambdaTest Selenium Java Certification

A Selenium + TestNG automation project for LambdaTest Playground using Selenium Java with parallel execution on LambdaTest Cloud Grid.

## Prerequisites

- Java 17 
- Maven
- LambdaTest Account
- Selenium 4
- TestNG 7

### LambdaTest Configuration
Get LambdaTest credentials:
```bash
- In windows platform
set LT_USERNAME="carrieyanzh"
set LT_ACCESS_KEY="LT_DSaDbhGJPOhItmeOgbK2PVHOkZNm6xTMbaEf0AHHqQJ9GHW"
```

Execute Tests
```bash
mvn clean test

The tests will run in parallel on LambdaTest Grid 
```

Test Configuration
- Framework: TestNG
- Parallel Execution: class level
- Browser Combinations:
  - Chrome + 128.0 + Windows 10
  - Microsoft Edge + 127.0 + macOS Ventura
  - Firefox 130.0 + Windows 11
  - Internet Explorer + 11.0 + Windows 10


### Test IDs: DA-WIN-2131766-1762304452333376576GIN

## 📁 Project Structure

```bash
# Project Structure
cyzseleniumjava101/
├── .gitignore
├── .gitpod.yml
├── README.md
├── pom.xml
├── testng.xml
├── src/
│ └── test/
│ ├── java/
│ │ └── org/
│ │     └── lambdatest/
│ │         ├── BaseTest.java
│ │         ├── helper/
│ │         │   └── JSONReader.java
│ │         ├── pages/
│ │         │ ├── SimpleFormDemoScreen.java
│ │         │ ├── InputFormSubmitScreen.java
│ │         │ ├── DragDropSlidersScreen.java
│ │         │ └── SeleniumPlaygroundMainPage.java
│ │         └── tests/
│ │             └── PlaygroundAssignTests.java
│ └── resources/
│     └── testdata.json

```







----
Issues: 
Internet Explorer - NOT SUPPORTED
End of life: June 15, 2022; 
So adding some checks:
```bash
        EdgeOptions ieEdgeOptions = new EdgeOptions();
        browserOptions = ieEdgeOptions;
        ltOptions.put("ie.compatibility", true); // Enables IE Mode
        if ("11.0".equals(version)) {
          ltOptions.put("browserVersion", "127.0"); // Example Edge version supporting IE Mode
        } else {
          ltOptions.put("browserVersion", version);
        }
```


