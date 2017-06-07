# ReadMe
Refer [here](https://community.smartbear.com/t5/SoapUI-NG/How-to-setup-TestSuite-Priority-for-a-Project-with-multiple/m-p/143643/highlight/false#M32424) for more details

This project has 3 test suites. User would like to execute 
- first test suite in sequential
- second and third suites in parallell

## How to Achieve that?
  - In order to achieve that, since that is something not supported by `SoapUI`, user can write a `groovy` script.
### Where to place that `groovy` script?
 - Create a test suite, say `runSuites` -> test case -> add a test step of `Groovy Script` type. 
 NOTE: it is not required to do the above if you are using [this project](https://github.com/nmrao/sample-soapui-projects/blob/master/hybridExecution/testThreads-soapui-project.xml)
### How to run the mentioned suites in the requested manner?
- Get the [project](https://github.com/nmrao/sample-soapui-projects/blob/master/hybridExecution/testThreads-soapui-project.xml) and copy it into any directory
- Open command prompt, go to `SOAPUI_HOME/bin` directory
- Run `testrunner.bat (or .sh)` and pass the absolute path of the above project in order to execute the project. You would see the console log which suite(s) is currently being executed. This is the main reason for asking to execute the project command line.
- Of course, you can execute it from within `SoapUI` tool as well. In that case, just run the suite `runSuites` alone which takes care of running other suites sequentially and then in parallel.