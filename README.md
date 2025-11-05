# cyzseleniumjava101
Taking LambdaTest Java 101 Exam
A Selenium + TestNG automation project for LambdaTest Playground.


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

Tech Stack
1) Java 17
2) Selenium 4
3) TestNG 7
4) Maven
5) Page Object Model (POM)
6) LambdaTest Remote WebDriver

Env: In windows platform:
set LT_USERNAME="carrieyanzh"
set LT_ACCESS_KEY="LT_DSaDbhGJPOhItmeOgbK2PVHOkZNm6xTMbaEf0AHHqQJ9GHW"

Test IDs: DA-WIN-2131766-1762304452333376576GIN

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

