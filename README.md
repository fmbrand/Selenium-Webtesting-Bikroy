markdown
Copy code
# Bikroy.com Web Automation with Selenium (Java)

## Overview

This project automates various interactions on the Bikroy.com website using Selenium WebDriver in Java. The automation includes actions like navigating through categories, performing searches, applying filters, and validating elements, making the testing process efficient and repeatable.

## Features

- Automated navigation through Bikroy.com
- Search functionality testing
- Applying filters and validating results
- Extracting data from listings
- Verification of web elements across pages

## Technologies Used

- **Java**: Programming language for writing test scripts.
- **Selenium WebDriver**: For browser automation.
- **TestNG/JUnit**: For managing test cases (optional).
- **Maven/Gradle**: For project and dependency management.
- **ChromeDriver/GeckoDriver**: WebDriver for Chrome/Firefox browsers.

## Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**: Install JDK 8 or higher. Download from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html).
   
2. **Maven/Gradle**: Ensure Maven or Gradle is installed and configured.

3. **Selenium WebDriver**: Managed via Maven/Gradle dependencies.

4. **WebDriver**: Download the appropriate WebDriver for your browser:
   - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
   - [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

### Project Setup

1. **Maven Configuration**:
   Add the following dependencies to your `pom.xml` if using Maven:

   ```xml
   <dependencies>
       <!-- Selenium Dependency -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.0.0</version>
       </dependency>

       <!-- TestNG Dependency (Optional) -->
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.4.0</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
2. **WebDriver Setup:** Place `chromedriver.exe` or `geckodriver.exe` in your system’s PATH or the project’s drivers/ directory.
### How to Run the Tests
1. **Run with Maven:** Navigate to the project directory and use Maven to run the tests.

`mvn test`

2. **Run Individually (JUnit/TestNG):** In your IDE (e.g., IntelliJ or Eclipse), right-click on any test file and run as a TestNG or JUnit test.

3. **Browser Configuration:** In your BaseTest.java, ensure the WebDriver path is set correctly:

`System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
WebDriver driver = new ChromeDriver();`
### Test Classes
1. **BaseTest.java**
Contains common setup and teardown methods to initialize and close the browser before and after every test.

2. **NavigationTest.java**
Automates navigation through Bikroy.com categories and verifies elements on each page.

3. **SearchTest.java**
Tests the search feature by verifying that results match various search queries.

4. **FilterTest.java**
Tests the filter functionality, ensuring results match applied filters.

### Troubleshooting
**WebDriver Issues:** Ensure the WebDriver version matches your browser version.
**Element Not Found:** Use appropriate locators and adjust WebDriverWait timing if necessary.
**Browser Compatibility:** Ensure the correct WebDriver is used (e.g., ChromeDriver for Chrome).
### Contributing
Feel free to fork this repository, submit issues, or open pull requests to contribute to the project.
