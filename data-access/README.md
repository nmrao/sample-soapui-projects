# READ ME

Usually, simple data types can be stored in custom properties. However, users can't store complex data types.
Here is a way to access the complex data types. 

There is a variable _context_ across the project. And users can set their data in the _context_ and access the same where it is required. However, note that this works when you run test case, but not individual test steps (in below cases). Similarly you can use _context_ available at _project, testSuite_ level as well. In those cases, those variables works when _project, testSuite_ is run respectively.

Monitor script log while running the test cases for below examples.

#### ListType

This test case shows how to access the list data
**Setup Script** 
User sets list of colors in _Setup Script_
**accessColors** step
Access the colors in _accessColors_ **Groovy Script** test step.

#### ClassType
This test case shows how to access the user profiles and do some computations on the data.
**Setup Script**
Here, _UserProfile_ class is defined along with data.
**accessUsers**
Access the _users_ and do some computations.

####BetweekScripts
This is to show that it is also possible to set data in a test step and access the data in another test step.

**NOTE:** It is good to share the data across project, suite. However, make sure each test case is independent. i.e., at any time, each test case should be able to run without dependent any other cases / suite / project to achieve good automation.
