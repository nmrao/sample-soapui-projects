# README

This project reads external files and add them to setup and teardown scripts for each test case of given test suite.

- For example, there are setup.groovy and teardown.groovy script files.
- And you have a project with multiple suites. 
- Required to add the same setup and teardown scripts for each of the test case of given test suite(s)
- Running this project will add the same to your project.


#### How to run this project?
You need to run [addSetupTearDown-soapui-project.xml](https://github.com/nmrao/sample-soapui-projects/blob/master/addSetupTeardownScript/addSetupTearDown-soapui-project.xml) project with **testrunner** utility.

##### on linux
```
cd $SOAPUI_HOME/bin
testrunner.sh -P PROJECT=/path/to//original-test-soapui-project.xml -P SUITE="TestSuite 4, TestSuite 5" -P SETUP=/tmp/setup.groovy -P TEARDOWN=/tmp/teardown.groovy /path/to/this/addSetupTearDown-soapui-project.xml
```
##### on windows
```
cd %SOAPUI_HOME%\bbin
testrunner.bat -P PROJECT=/path/to//original-test-soapui-project.xml -P SUITE="TestSuite 4, TestSuite 5" -P SETUP=/tmp/setup.groovy -P TEARDOWN=/tmp/teardown.groovy /path/to/this/addSetupTearDown-soapui-project.xml
```

If you look at the above, it is clear that we need to pass following project level parameters to `testrunner` utility.

- _PROJECT_ : this is path of the project to which you like to add the setup and teardown scripts
- _SUITE_ : name of the test suite(s). If there are more than one, separate them by comma and enclose the values between double quotes as shown above.
- _SETUP_ : this is the absolute path of the setup script
- _TEARDOWN_ : this is the path of the teardown script.

And the last one is path to [this project](https://github.com/nmrao/sample-soapui-projects/blob/master/addSetupTeardownScript/addSetupTearDown-soapui-project.xml)

NOTE: this project is created and tested in SoapUI OS 5.4 version. It should work with ReadAPI as well.
