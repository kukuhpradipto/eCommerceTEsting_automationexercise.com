> #### Repository will always be updated 


# 🛍️ eCommerce Testing Automation - automationexercise.com

Automated testing project built using Selenium WebDriver, TestNG, Page Object Model (POM), Apache POI, and ExtentReports.

> ✅ Designed for UI automation testing with negative and positive test cases.

---

## 📉 Project Overview

This project automates the functional UI testing of the website `https://automationexercise.com` by simulating various user interactions like login, registration, submission, and logout.

Goals:

* Ensure core features are functional and error.
* Handle both **positive** and **negative** test scenarios.
* Generate readable reports for each execution.
* Use data-driven testing (via Excel) to manage test cases flexibly.

---

## 🛠️ Tech Stack

| Component          | Tool/Library                  |
| ------------------ | ----------------------------- |
| Language           | Java 11+                      |
| Automation Tool    | Selenium WebDriver            |
| Test Framework     | TestNG                        |
| Design Pattern     | Page Object Model (POM)       |
| Reporting          | ExtentReports                 |
| Excel Integration  | Apache POI                    |
| Dependency Manager | Maven                         |
| Driver Management  | WebDriverManager (Bonigarcia) |

---

## 📂 Folder Structure

```
src/
├── base/                    # Base classes (e.g., BaseTest)
├── pages/                   # Page Object Models
│   ├── HomePages/
│   ├── RegistrationPages/
│   └── LoginPages/
├── test/                   # Test classes grouped by features
│   ├── LoginTest/
│   ├── RegistrationTest/
│   └── LogoutTest/
├── testdata/               # Excel files used for data-driven testing
└── utils/                  # Utility classes (Excel, Reporting, etc.)
```

---

## 🚀 Getting Started

### Prerequisites

* Java 11+
* Maven
* IDE (IntelliJ IDEA)

### How to Run

1. Clone the repository:

```bash
git clone https://github.com/kukuhpradipto/eCommerceTEsting_automationexercise.com
```

2. Import as Maven project in your IDE.
3. Install dependencies:

```bash
mvn clean install
```

4. Run the test suite:

```bash
mvn test
```

TestNG will execute the tests as per `testng.xml` configuration.

---

## 🧪 Test Coverage

### ✅ Login Test

* L01: Positive Login (valid credentials)
* L02: Negative Login (blank fields, invalid inputs)

### ✍️ Registration Test

* R01: Positive Registration
* R02: Negative Registration - duplicate user
* R03: Negative Registration - form field validations

### 🔒 Logout Test

* LG01: Logout scenario after login

---

## 📸 Reporting

📍 Using **ExtentReports** to generate a visual HTML report for every test execution.

* Report auto-generated at:
  `/test-output/ExtentReport.html`

Features:

* Status: Pass / Fail / Skip
* Screenshots on failure
* Step-by-step logging

---

## 📊 Data Driven Testing

Integrated with **Apache POI** to read test input from Excel files:

* Located in: `src/testdata/*.xlsx`
* Examples:

    * `LoginForm.xlsx`
    * `RegisterForm.xlsx`

Supports:
* Multiple input sets
* Blank field validations
* Dynamic testing via `@DataProvider`

---

## 📌 Sample Test Case


### ✍️ Registration Test (R01 - Positive Registration)

```java
@Test(priority = 1)
public void RegisterTest_PositiveCase() {
    test = extent.createTest("Positive Case Registration: Successful account creation");

    homePage.goToLoginRegister();
    loginRegisterPage.userNameRegister("kukuhuser");
    loginRegisterPage.emailRegister("kukuh@gmail.com");
    loginRegisterPage.signUpButton();
    
    registrationPage.fillRegistrationForm(...);
    registrationPage.buttonCreateAccountRegistration();

    String successMessage = registrationPage.verifyAccountCreated();
    Assert.assertEquals(successMessage, "ACCOUNT CREATED!");
    test.pass("Account successfully created");
}
```

### ❌ Registration Test (R02 - Negative Registration)

```java
@Test(priority = 2)
public void RegisterTest_DuplicateEmail() {
    test = extent.createTest("Negative Case Registration: Email already registered");

    homePage.goToLoginRegister();
    loginRegisterPage.userNameRegister("kukuhuser");
    loginRegisterPage.emailRegister("kukuh@gmail.com"); // existing email
    loginRegisterPage.signUpButton();

    String warning = loginRegisterPage.getEmailExistWarning();
    Assert.assertTrue(warning.contains("Email Address already exist!"));
    test.pass("Displayed warning for duplicate email: " + warning);
}
```

### ❌ Registration Test (R03 - Negative Registration)

```java
@Test(dataProvider = "NegativeCaseInputRegisterForm")
public void RegisterTest_NegativeCase(String username, String email, String password, ...) {
    if (password.trim().isEmpty()) {
        test = extent.createTest("Negative Case Registration: Password is blank");
    }

    loginRegisterPage.userNameRegister(username);
    loginRegisterPage.emailRegister(email);
    loginRegisterPage.signUpButton();

    registrationPage.passwordRegistration(password);
    registrationPage.buttonCreateAccountRegistration();

    String tooltip = toolTips.passwordRegistrationToolTipsValidation();
    Assert.assertEquals(tooltip, "Please fill in this field.");
    test.pass("Tooltip appeared: " + tooltip);
}
```

### ✅ Login Test (L01 - Positive Login)

```java
@Test(priority = 1)
public void LoginTest_PositiveCase() {
    test = extent.createTest("Positive Case Login: Login with valid credentials");

    homePage.goToLoginRegister();
    loginPage.enterEmail("kukuh@gmail.com");
    loginPage.enterPassword("validpassword");
    loginPage.clickLoginButton();

    Assert.assertTrue(dashboardPage.isUserLoggedIn());
    test.pass("User successfully logged in and redirected to dashboard");
}
```

### ❌ Login Test (L02 - Negative Login)

```java
@Test(dataProvider = "invalidLogin")
public void LoginTest_NegativeCase(String email, String password) {
    test = extent.createTest("Negative Case Login: Invalid login with email: " + email);

    homePage.goToLoginRegister();
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();

    Assert.assertTrue(loginPage.getErrorMessage().contains("incorrect"));
    test.pass("Login failed as expected with invalid credentials");
}
```

### 🔓 Logout Test (LG01 - Logout Scenario)

```java
@Test(priority = 1)
public void LogoutTest_PositiveCase() {
    test = extent.createTest("Positive Case Logout: Log out after successful login");

    homePage.goToLoginRegister();
    loginPage.enterEmail("kukuh@gmail.com");
    loginPage.enterPassword("validpassword");
    loginPage.clickLoginButton();

    dashboardPage.clickLogoutButton();
    Assert.assertTrue(homePage.isAtHomePage());
    test.pass("User successfully logged out and redirected to home page");
}
```


