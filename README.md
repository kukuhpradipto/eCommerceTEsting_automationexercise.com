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

├── test/                    # Test classes grouped by features

├── testdata/                # Excel files used for data-driven testing
└── utils/                   # Utility classes (Excel, Reporting, etc.)
```

---

## 🚀 Getting Started

### Prerequisites

* Java 11+
* Maven
* IDE (IntelliJ IDEA)

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

Supports:
* Multiple input sets
* Blank field validations
* Dynamic testing via `@DataProvider`

---
