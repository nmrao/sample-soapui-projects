# README
## _Loading the environment from groovy configuration file from command line_

### Context
Many times users have multiple test environments to execute the soapui project
This is very easy achieve and manage if the property expansion are used in the project. 
_For ex:_
>whereever service host and port are needed, use ${#Project#SERVICE_HOST}, ${#Project#SERVICE_PORT}
>Similarly any number of properties be used

In this approach, it does not matter what values for the project properties are saved. SOAPUI / ReadyAPI tools allows user to override those property values during the test execution from the command-line with a project property as arugment so that existing project properties are overridden.
- Here the use wants use single configuration for all the environments. For this, we can leverage the groovy for configuration of different environments. 
- Also not just environments, but also like to have configurations for different software versions.
- User can also have generic properties which are common for all the environments in `common`  section of the Config.groovy.

#### Project
To domonstrate how this works, create a project and required artifacts to test this approach.
- This project contains a _Test Suite => Test Case => Groovy Script_ test step.
- The _Groovy Script_ test step access the project properties. Of course, any test step in the project can access these properties.
- All the configurations are mentioned in the `Config.groovy`. This very easy to define configuration as well simple exapmple. This is like data as code.

```
//Define the environments 
environment {
    qa {
    	//Define software release version wise configuration       
    	'r1' {
    		SERVICE_HOST = 'r1.host1.com'
			SERVICE_PORT = 8443
			DB_HOST = 'r1.testdb.com'
    	}
    	'r1.1' {
    		SERVICE_HOST = 'r1.host1.com'
			SERVICE_PORT = 8445
			DB_HOST = 'r1.testdb.com'
    	}
    }
    staging {
    	'r1' {
    		SERVICE_HOST = 'r1.staging.host1.com'
			SERVICE_PORT = 8443
			DB_HOST = 'r1.stagingdb.com'
    	}
    	'r1.1' {
    		SERVICE_HOST = 'r1.staging.host1.com'
			SERVICE_PORT = 8445
			DB_HOST = 'r1.stagingdb.com'
    	}
    }
}
```
 - Here need to be able read the _environment_, _release_ and configuration file run time i.e., command line and parse the file, extract the required properties and assign them at the project level.
- So, use needs to pass the following arguments to `testrunner` command
```    
    -Penv => Name of the environment
    -Prelease => Software version
    -Pconfig => File path of the Groovy configuration
```
- Here is the excerpt from the command line execution of the project and they show the correct values loaded from the property file. Notice the log statements.
- You can see the command

Running the test on QA environment for release r1
```
./testrunner.sh testProperties-soapui-project.xml -Penv=qa -Prelease=r1 -Pconfig=/tmp/Config.groovy
```
Log excerpt from command line execution.
NOTE: the **log** statements below
```
13:02:40,078 INFO  [SoapUITestCaseRunner] Setting project property [config] to [/tmp/Config.groovy]
13:02:40,078 INFO  [SoapUITestCaseRunner] Setting project property [env] to [qa]
13:02:40,078 INFO  [SoapUITestCaseRunner] Setting project property [release] to [r1]
13:02:40,079 INFO  [SoapUITestCaseRunner] Running SoapUI tests in project [testProperties]
13:02:40,080 INFO  [SoapUITestCaseRunner] Running Project [testProperties], runType = SEQUENTIAL
13:02:40,523 INFO  [log] Using qa environment for the software version r1
13:02:40,641 INFO  [SoapUITestCaseRunner] Running SoapUI testcase [TestCase1]
13:02:40,641 INFO  [SoapUITestCaseRunner] running step [Groovy Script]
13:02:40,662 INFO  [log] Following are the project properties
13:02:40,663 INFO  [log] ENVIRONMENT_NAME => qa : r1
13:02:40,663 INFO  [log] SERVICE_HOST => r1.host1.com
13:02:40,663 INFO  [log] SERVICE_PORT => 8443
13:02:40,664 INFO  [log] DB_HOST => r1.testdb.com
13:02:40,664 INFO  [log] USER => engineer1
13:02:40,679 INFO  [SoapUITestCaseRunner] Finished running SoapUI testcase [TestCase1], time taken: 21ms, status: FINISHED
13:02:40,705 INFO  [SoapUITestCaseRunner] Project [testProperties] finished with status [FINISHED] in 596ms
```

Running tests on Staging environment with release r1.1

```
bash $ ./testrunner.sh testProperties-soapui-project.xml -Pconfig=/tmp/Config.groovy -Penv=staging -Prelease=r1.1

13:14:24,335 INFO  [SoapUITestCaseRunner] Setting project property [config] to [/tmp/Config.groovy]
13:14:24,335 INFO  [SoapUITestCaseRunner] Setting project property [env] to [staging]
13:14:24,335 INFO  [SoapUITestCaseRunner] Setting project property [release] to [r1.1]
13:14:24,335 INFO  [SoapUITestCaseRunner] Running SoapUI tests in project [testProperties]
13:14:24,336 INFO  [SoapUITestCaseRunner] Running Project [testProperties], runType = SEQUENTIAL
13:14:24,803 INFO  [log] Using staging environment for the software version r1.1
13:14:24,822 INFO  [SoapUITestCaseRunner] Running SoapUI testcase [TestCase1]
13:14:24,900 INFO  [SoapUITestCaseRunner] running step [Groovy Script]
13:14:24,914 INFO  [log] Following are the project properties
13:14:24,915 INFO  [log] ENVIRONMENT_NAME => staging : r1.1
13:14:24,915 INFO  [log] SERVICE_HOST => r1.staging.host1.com
13:14:24,915 INFO  [log] SERVICE_PORT => 8445
13:14:24,915 INFO  [log] DB_HOST => r1.stagingdb.com
13:14:24,916 INFO  [log] USER => engineer1
13:14:24,925 INFO  [SoapUITestCaseRunner] Finished running SoapUI testcase [TestCase1], time taken: 14ms, status: FINISHED
13:14:24,949 INFO  [SoapUITestCaseRunner] Project [testProperties] finished with status [FINISHED] in 587ms
```

**NOTE**: For those like to use from the UI, you need to do the following:

-- Set the project properties 
    
    config => absolute path of Config.groovy file
    env => name of the environment from the above configuration file
    release => software version used from the above configuration file

-- Execute the project level Setup Script or execute the project directly
