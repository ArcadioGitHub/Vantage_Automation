## Vantage Automation
This repository uses:
```
Selenium
Cucumber
Gherkin
SerenityBDD
Java 8
chromedriver
Junit
Gradle
```

## Environment Setup
```
1 --> Install Java 8 --> https://www.java.com/es/download/help/windows_manual_download.html#download
2 --> Install Gradle --> https://gradle.org/install/
3 --> Install an IDE, IntelliJ would be fine (Optional)
```

## Install Dependencies
```
Using the IDE.
Open the project and run the file "build.gradle".
```

## Run Tests
```
Using the CMD.

To run all the tests --> "gradle clean test aggregate" (This command also creates an HTML report with the results of each run).
```

## Managing Environments and Browsers
```
Example --> "gradle clean test aggregate -Denvironment=dev -Dcontext=chrome -Dwebdriver.driver=chrome -Dinjected.tags=browser:chrome"

-Denvironment -> (default, dev, staging, prod) Env in which you want to run the tests, if the parameter is not included it will run in a 'default' environment defined by default in the serenity.conf file.

-Dwebdriver.driver --> Parameter to indicate in which browser the tests will be executed.

-Dcontext and Dinjected.tags --> Parameters used by serenity to add tags and differentiate the browsers in which the tests were run when generating the HTML report.
```

## Using the IDE.
```
To run a single test --> Go to the Runners folder, open the Java class called "Runner" and change the @Tags. 

To run all the tests you must use the @Tag of the .feature. 

It would be something like the following:

@CucumberOptions(features = {"src/test/resources/features/"},
        tags = "@TagToUse",
        glue = "Definitions",
        snippets = SnippetType.CAMELCASE )
```			
## CI.
```
In the file Jenkins.file is coded the Pipeline for its execution in Jenkins.
```

## About the Framework and the Design Pattern
```
The framework is built under BDD (Behavior Driven Development) under the POM (Page Object Model) design pattern.

All test logic can be found in -> src/test/java/PageObjects/

The Runner for the tests can be found at -> src/test/Runners/Runner

The definition of the test steps (Orchestrator) can be found at -> src/test/Definitions

The test behavior is written in Gherkin with the main idea that a person without programming knowledge can understand what the test is doing.

You can find the .feature of the test here -> src/test/resources/environments.feature.
```

## Reports
```
An HTML report is automatically created for each test run using this command -> "gradle clean test aggregate".

You can find the report here -> target/site/serenity/index.html
```