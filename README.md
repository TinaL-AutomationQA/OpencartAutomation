#**Selenium Test Automation Framework**
##Overview

This is a hybrid automation testing framework built using **Selenium**, **TestNG**, and **ExtentReports**. It is designed to test web applications with a focus on scalability, reusability, and maintainability. The framework supports key testing scenarios, including functional testing, regression testing, and data-driven testing.

This framework was developed as part of my self-learning journey to enhance my skills in automation testing.

##Features

- **Page Object Model (POM)**: Encapsulates web elements and actions for better code organization and reuse.
- **Data-Driven Testing**: Integrates with Apache POI to dynamically read test data from Excel files.
- **Test Reporting**: Generates detailed HTML reports using ExtentReports, including test results, logs, and screenshots for failed tests.
- **Configuration Management**: Centralized management of test settings using `config.properties`.
- **Cross-Browser Testing**: Supports testing on Chrome, Firefox, and Edge.
- **Logging**: Configured with Log4j for detailed execution logs.

##Project Structure
```bash
src/test/java
│
├── pageObjects         # Page Object classes for encapsulating web elements and actions
│   ├── LoginPage.java
│   ├── HomePage.java
│   └── ...
│
├── testCases           # Test classes for functional and regression testing
│   ├── LoginTest.java
│   ├── RegistrationTest.java
│   └── ...
│
├── testBase            # Base class for WebDriver setup and configuration
│   └── BaseClass.java
│
├── utilities           # Utility classes for common functions
│   ├── DataProviders.java
│   ├── ExcelUtility.java
│   ├── ExtentReportManager.java
│   └── ...
│
├── resources           # Configuration and property files
│   ├── config.properties
│   └── log4j2.xml
│
├── reports             # Generated test reports (ExtentReports)
├── screenshots         # Screenshots for failed test cases
```

##How to Use

1.Clone the Repository
git clone https://github.com/TinaL-AutomationQA/OpencartAutomation.git

2.Import the project into your IDE (e.g., IntelliJ IDEA or Eclipse).
3.Configure the config.properties file:
4.Set the browser type (e.g., chrome).
5.Set the application URL.
6.Run the desired TestNG XML file (e.g., testng.xml) to execute the test suite.

##Technologies Used

Programming Language: Java
Automation Tool: Selenium WebDriver
Test Management: TestNG
Reporting: ExtentReports
Data Handling: Apache POI (Excel)
Build Tool: Maven
Logging: Log4j

##Test Reports
The framework generates detailed HTML reports using ExtentReports. Reports include:

Test execution status (Pass/Fail/Skip).
Failure details with screenshots.
Logs for debugging.
Sample report:
[![Report Screenshot](https://github.com/TinaL-AutomationQA/OpencartAutomation/blob/master/report%20screenshot/Report_with_screenshot.png)

##Future Enhancements

.Integrate with CI/CD tools like Jenkins.
.Add support for API testing with RestAssured or Postman.
.Implement Dockerized Selenium Grid for easier remote execution.

##Contact

If you have any questions or suggestions about this framework, feel free to reach out!
Email: [liut44194@gmail.com]
GitHub Profile: https://github.com/TinaL-AutomationQA
