# Summary :
**SoapUI** or **SoapUI NG** tool allows users to run the test cases either in *Parallell* or *Sequential* modes. But, does not allow to execute test steps of a test case in *Parallell* mode.

This project is to domonstrate how one can achieve the same by using *Groovy Script*.
### How To Use

  - Import the project [thread-soapui-project.xml](https://github.com/nmrao/sample-soapui-projects/blob/master/runStepsInParallel/thread-soapui-project.xml) into SoapUI tool.
  - Open the suite, `TestSuite 1`
  - There is case, `Test1` which contains two steps, say, `step1` and `step2`. Using groovy script type steps where each step takes different time to complete (simulating different work which may take different time in real world by having **thread sleep**)
  - For demonstration and simplicity used `Groovy Script` type steps. User can use any different type of step as needed.
  - Next, there is another case, `runStepsParallell` with a **Groovy Script** step, which actually runs the steps of above test case in **parallell** using *multi-threading*. So, all user needs to is run this step. Running this test case will also do the same.

Note :
  - This project is created & tested using SoapUI 4.5.1. However, hoping that it should be compatible with other versions.

### Output
On running the above, the following log is shown either in `script log` or `Log Output` tabs of SoapUI.

```sh
Fri Aug 05 22:01:43 IST 2016:INFO:this script is being started
Fri Aug 05 22:01:43 IST 2016:INFO:this script completed
Fri Aug 05 22:01:43 IST 2016:INFO:calling step1 @ 1470414703043
Fri Aug 05 22:01:43 IST 2016:INFO:calling step2 @ 1470414703043
Fri Aug 05 22:01:43 IST 2016:INFO:Started step1
Fri Aug 05 22:01:43 IST 2016:INFO:Started step2
Fri Aug 05 22:01:43 IST 2016:INFO:step1 In progress
Fri Aug 05 22:01:43 IST 2016:INFO:step2 In progress
Fri Aug 05 22:01:45 IST 2016:INFO:step2 Finished @ 1470414705077
Fri Aug 05 22:01:47 IST 2016:INFO:step1 Finished @ 1470414707081
```

### Description :
As you see the log, `runStepsParallell` script started, started the two steps of the test case that user wanted in threads, then it completed. 

However, the two steps running in separate threads -
- both steps started same time
- take its own time to execute a step
- finished in different times
