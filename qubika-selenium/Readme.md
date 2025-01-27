# Qubika Automation Tests

## Overview
This project automates the testing of the Qubika website using **Java**, **Selenium WebDriver**, and **TestNG**. The tests validate various workflows, including:
- Verifying the homepage URL and logo.
- Checking the "Contact Us" form fields.
- Validating error messages and styling.

---

## Prerequisites

1. **Java Development Kit (JDK)**:
   - Install JDK 11 or later from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [AdoptOpenJDK](https://adoptium.net/).
   - Verify the installation:
     ```bash
     java -version
     ```

2. **Apache Maven**:
   - Download and install [Maven](https://maven.apache.org/download.cgi).
   - Verify the installation:
     ```bash
     mvn -version
     ```

3. **WebDriverManager**:
   - This project uses WebDriverManager for automatic browser driver management.

4. **Eclipse IDE (Optional)**:
   - Install [Eclipse IDE](https://www.eclipse.org/downloads/) for a GUI-based development environment.

---

## Setup

1. **Clone the Repository**:
   Clone the project from your repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Import into Eclipse (Optional)**:
   - Open Eclipse.
   - Go to **File > Import > Existing Maven Projects**.
   - Select the project folder and click **Finish**.

3. **Install Dependencies**:
   Run the following Maven command to download and install the dependencies:
   ```bash
   mvn clean install
   ```

---

## Running the Tests

1. **From the Command Line**:
   - To execute all tests, run:
     ```bash
     mvn test
     ```

2. **From Eclipse**:
   - Right-click on the test class (e.g., `QubikaAutomationTest`) in the Project Explorer.
   - Select **Run As > TestNG Test**.

---

## Project Structure
```
project-root/
├── pom.xml                # Maven configuration file
├── src/
│   ├── main/
│   │   └── java/
│   ├── test/
│   │   └── java/
│   │       └── com/qubika/tests/
│   │           └── QubikaAutomationTest.java  # Test class
│   └── test/resources/
```

---

## Test Description

| **Test Name**               | **Description**                                                                                      |
|-----------------------------|------------------------------------------------------------------------------------------------------|
| `validateHomePage`          | Validates the homepage URL and ensures the Qubika logo is visible.                                   |
| `validateContactForm`       | Clicks the "Contact Us" button and validates the presence of the form fields.                        |
| `validateErrorMessages`     | Validates the error messages and border styling for "Name" and "Email" fields in the contact form.   |

---

## Reporting

1. **TestNG Reports**:
   - After running the tests, TestNG generates reports in the `test-output` folder.
   - Open the `index.html` file in a browser to view the report.


---

## Troubleshooting

| **Issue**                                 | **Solution**                                                                                           |
|-------------------------------------------|-------------------------------------------------------------------------------------------------------|
| Maven build errors                        | Run `mvn clean install` to resolve dependencies.                                                     |
| WebDriverManager errors                   | Ensure your internet connection is active, as it downloads browser drivers.                          |
| `java.lang.UnsupportedClassVersionError` | Ensure your JDK version is 11 or later.                                                              |
| TestNG not recognized in Eclipse          | Install the TestNG plugin from Eclipse Marketplace.                                                  |



