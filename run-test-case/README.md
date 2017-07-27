# Sample soapui project for "Run TestCase"

[This project](https://github.com/nmrao/sample-soapui-projects/blob/master/run-test-case/run-testcase-soapui-project.xml) demonstrates how to use `template test case` and re-use it in different test cases. Here user can pass both input and output properties between the caller and callee test cases.

## Project Artifacts - TestSuite1
  - templateTestCase: This is a template test case and can be reused by calling it from other test cases. Hence this test case is disabled.  
  
### What does this template test case do?  

To demonstration, this template case just takes 2 inputs from user and merges both values and return value set to the caller test case property. Of course, user can add their own implementation of the template test case, change parameters etc., as per the requirement.
---
  - **TestCase1:** This test case calls "templateTestCase" in "Run TestCase" step. It passes two input data say INPUT1, and INPUT2. And do some computation based on input  and returns the value to a given property say `RETURN_VALUE`. Finally after finishing the "run testcase" step, print the return value in current test case, getData test step
  - **TestCase2:** Same as above except that property name for the return value is different i.e., `OUTPUT_VALUE`

NOTE: 
 - Since this is for the demonstration purpose, have used only `Groovy Script` steps. Of course, you can use any type of steps as needed.
  
## What user should do?

  - Run the test suite `TestSuite1`
  - And see the script log, you would see log something like below
```
INFO:Setting the data for test case TestCase1
INFO:In template test case, doing the required stuff for TestCase1 test case
INFO:Return value : TestCase1 input1 1501135190529TestCase1 input2 1501135190529
INFO:Setting the data for test case TestCase2
INFO:In template test case, doing the required stuff for TestCase2 test case
INFO:Return value : TestCase2 input1 1501135190576TestCase2 input2 1501135190576
```
