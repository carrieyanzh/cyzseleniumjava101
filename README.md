# cyzseleniumjava101
Taking LambdaTest Java 101 Exam
# 🧪 cyzseleniumjava101

A Selenium + TestNG automation project for LambdaTest Playground.

---

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

🧰 Tech Stack
Java 17
Selenium 4
TestNG 7
Maven
Page Object Model (POM)
LambdaTest Remote WebDriver
---
mvn test
