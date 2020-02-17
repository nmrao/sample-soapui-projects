There are situations that a series of steps or a test case needs to be run as part of _Setup Script_ of test suite becuase that is not actually a test case.

[In this project](https://github.com/nmrao/sample-soapui-projects/blob/master/run-test-case/with-suite-setup/runcase-from-suite-soapui-project.xml), it demonstrates how to do so.

### OnlyRunFromSuiteSetup
This is test has sequence of steps which are part of _Setup Script_ of test suite. Since this case is **disabled**, it will never get execute as regular test and not part of test report which is the expected. However, user wants to run these steps as part suite setup.

#### How to run:
Have a glance thru the project before. Execute it as project or test suite and watch the logs.
