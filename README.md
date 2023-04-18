# Hostaway Technical Assignment

Hostaway Automation Project is a Java-based project that is designed to provide automation testing capabilities for UI
tests.
With this project, you can easily create and run automated tests for your web application which can save you time and
improve the quality of your software.

### Requirements

Please provide automation tests for https://kamil-demo.alpinizm.uz/ using Selenide (or Selenium), Allure, Java 11, JUnit
or TestNG (without Cucumber) which will do the following:

1. Check Filters form: entry fields, checkboxes, minimum and maximum values, Amenities checkboxes, “Clear all” is
   functional, check buttons without clicking "Apply".
   To reach the Filters form on https://kamil-demo.alpinizm.uz/ press the Search button, press the Filter button.
2. Check that the 'All listings' page (https://kamil-demo.alpinizm.uz/all-listings) has the same amount of listings as
   the 'All' label.

## Prerequisites

Before you can use My the framework, you will need to install the following software:

* **Java 11**: The Project is built on Java 17, so you will need to install this version of Java or a more recent
  version in order to run the project. You can download it from the official Java
  website: https://www.oracle.com/java/technologies/downloads/#java17
* **Maven 3.6.3**: My Project is built using Maven, so you will need to install this version of Maven or a more recent
  version in order to build and run the project. You can download it from the official Maven
  website: https://maven.apache.org/download.cgi

Once you have installed these prerequisites, you should be ready to start using the framework.

## Usage

The framework was configured to run tests during the `test` phase of the Maven build lifecycle. This ensures that all
tests are executed and any failures are caught before the project is deployed or released.

To run tests execute the following command from the root level of the project:

`mvn clean test`

## Github Results

The project was configured to run the above command on each PR creation.
You can check the last execution status [here](https://eugens21.github.io/hostaway-technical-assignment/30/).

## Results

To generate a testing report use:

`mvn allure:aggregate`

The command from bellow will aggregate all the reports from ui and api module into a single one available
inside [allure-report](./allure-report) directory. Open [index.html](./allure-report/index.html) in any browser to view
the report.
