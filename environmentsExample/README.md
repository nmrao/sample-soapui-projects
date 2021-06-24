# README
## _Loading the environment property file from command line_

### Context
Many times users have multiple test environments to execute the soapui project
This is very easy achieve and manage if the property expansion are used in the project. 
_For ex:_
>whereever service host and port are needed, use ${#Project#SERVICE_HOST}, ${#Project#SERVICE_PORT}
>Similarly any number of properties be used

In this approach, it does not matter what values for the project properties are saved. SOAPUI / ReadyAPI tools allows user to override those property values during the test execution from the command-line with a system property as arugment.
#### Project
To domonstrate how this works, create a project and required artifacts to test this approach.
- This project contains a _Test Suite => Test Case => Groovy Script_ test step.
- The _Groovy Script_ test step access the project properties. Of course, any test step in the project can access these properties.
- Created two property files. These property files are being passed as arguments to testrunner script command line. Each property file contains respective environment property values.
-- **qa.properties** 
-- **staging.properties**
- This is completely handled as out-of-the-box functionality of the tool, so no burden for the user at all.
- The argument needs to pass is -Dsoapui.properties.<projectName>=<property file path>
- The projectName in the above is what you see in when the project is opened in the tool. or you can find in the project properties Name field. In my case, my project is named as **"testProperties"**.
- Here is the excerpt from the command line execution of the project and they show the correct values loaded from the property file. Notice the log statements.
- You can see the command

Running the test on QA environment by passed respective property file
```
./testrunner.sh testProperties-soapui-project.xml -Dsoapui.properties.testProperties=qa.properties
```
Log excerpt from command line execution.
NOTE: the **log** statements below
```
20:25:04,885 INFO  [AbstractTestPropertyHolderWsdlModelItem] Overriding 4 properties from [qa.properties] in [testProperties]
20:25:04,991 INFO  [WsdlProject] Loaded project from [file:testProperties-soapui-project.xml]
20:25:04,994 INFO  [SoapUITestCaseRunner] Running SoapUI tests in project [testProperties]
20:25:04,995 INFO  [SoapUITestCaseRunner] Running Project [testProperties], runType = SEQUENTIAL
20:25:05,111 INFO  [SoapUITestCaseRunner] Running SoapUI testcase [TestCase1]
20:25:05,111 INFO  [SoapUITestCaseRunner] running step [Groovy Script]
20:25:05,267 INFO  [log] qa
20:25:05,267 INFO  [log] host1.in
20:25:05,267 INFO  [log] 8443
20:25:05,267 INFO  [log] my.db.host
20:25:05,274 INFO  [SoapUITestCaseRunner] Finished running SoapUI testcase [TestCase1], time taken: 155ms, status: FINISHED
20:25:05,274 INFO  [SoapUITestCaseRunner] Project [testProperties] finished with status [FINISHED] in 276ms
```

Running tests on Staging environment

```
bash $ ./testrunner.sh testProperties-soapui-project.xml -Dsoapui.properties.testProperties=staging.properties
```
Log excerpt from command line execution.
NOTE: the **log** statements below
```
20:28:43,826 INFO  [AbstractTestPropertyHolderWsdlModelItem] Overriding 4 properties from [staging.properties] in [testProperties]
20:28:43,935 INFO  [WsdlProject] Loaded project from [file:testProperties-soapui-project.xml]
20:28:43,937 INFO  [SoapUITestCaseRunner] Running SoapUI tests in project [testProperties]
20:28:43,938 INFO  [SoapUITestCaseRunner] Running Project [testProperties], runType = SEQUENTIAL
20:28:44,050 INFO  [SoapUITestCaseRunner] Running SoapUI testcase [TestCase1]
20:28:44,050 INFO  [SoapUITestCaseRunner] running step [Groovy Script]
20:28:44,206 INFO  [log] staging
20:28:44,206 INFO  [log] staging.host1.in
20:28:44,206 INFO  [log] 8443
20:28:44,206 INFO  [log] staging.db.com
20:28:44,214 INFO  [SoapUITestCaseRunner] Finished running SoapUI testcase [TestCase1], time taken: 155ms, status: FINISHED
20:28:44,214 INFO  [SoapUITestCaseRunner] Project [testProperties] finished with status [FINISHED] in 274ms
```
