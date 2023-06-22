# FrameWorkCucumber
This is a Cucumber+Selenium+TestNg+Maven Framework. Reports are generated using Extent Reports

This repository demonstrates the implementation of a Cucumber framework using Selenium Java, TestNG, and Maven. 
It allows you to write and execute behaviour-driven development (BDD) tests using Cucumber, 
automate web interactions with Selenium, manage test dependencies with TestNG, and build the project with Maven.

Tools and Technologies Used:
1.	Language – Java 16
2.	Testing Framework – TestNg
3.	BDD Framewrok – Cucumber JVM
4.	Build Tool – Maven
5.	Reporting – Cucumber Extent Report

Framework Structure:
	src/test/java/CommonUtils: This package consists of 5 Java Classes.
1.	CommonMethods.java: Consists of all the commonly used methods while testing.
2.	Assesrtion.java: This class consists of various assertion including a method for taking a screenshot.
3.	TestRunner.java: This is a runner class used to run the testcases.
4.	Constants: This class consits of constansts and paths required in the project.
5.	WebDriverSession.java: This class is cucumber hook which consists of Before and After hooks which is used to initiate web driver.
Before class starts the web driver whereas the after class closes the driver

	src/test/java/outputFiles: This package consists of all the screenshots.
	src/test/java/StepDefinitions: This package consists of all the glue code/ step definitions.
	src/test/java/WebPages: This package consists of the xpaths of all the Web elements in each web page in the Web application.
	src/test/java/FailedScreenshots: This package contains all the screenshots whenever the Test case is failed.
	src/test/java/Log: This package consists of LogListener and LogerUtil classes which are useful for logging the Test Steps in the Log file.
	src/test/resource/log4j.xml: This is log file where we can log each step of the test case.
	src/test/resource/drivers: This folder consists of the WebDriver.exe files of various webBrowsers.
	src/test/resource/Features: This folder consists of Cucumber feature files.
	reports: This type of folder consists of HTML and PDF test reports of every test performed.
	pom.xml: This file consists of all the dependencies, plugins, configuration etc to build a project.

 


Steps to Setup and Run the Code.
Step 1: Download and install Java 16 and configure java path.
Step 2: Download and install Maven and configure maven path.
Step 3: Configure JavaHome and MavenHome in environment variable.
Step 4: Install IDE (Eclipse/IntellIJ Idea).
Step 4: Open the Project in IDE.
Step 5: Check whether pom.xml file consists of all the below dependencies:
1.	cucumber-java
2.	selenium-java
3.	Junit
4.	Cucumber-junit
5.	Webdrivermanager
6.	TestNg
7.	Log4j
8.	Cucumber-testng
9.	extentreports
10.	extentreopts-cucumber7-adapter
Step 6: Add following plugins
1.	TestNg Plugin
2.	Cucumber Plugin
Step 7: Open Test Runner file.
Step 8: Choose suitable tag and Run as Junit Test.



