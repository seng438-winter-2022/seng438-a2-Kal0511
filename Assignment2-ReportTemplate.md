**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      | 19   |
| -------------- | --- |
| Student Names: |   Eric Renno  |
|                |   Ryan Sommerville  |
|                |   Quinn Ledingham  |
|                |   Kaumil Patel  |

# 1 Introduction
The purpose of this lab is to explore how to use Junit tests to thoroughly test the methods of a particular class in order to ensure that the class functions as it should. To do this, the Junit class allows you to create a test function and compares the correct result with the result that the function actually returns. Although the process is straightforward, accurately testing a class requires a thorough analysis of boundary cases and other necessary test cases for each method. Additionally, 

# 2 Detailed description of unit test strategy
The test was performed using the Eclipse IDE. First, java files were created for the test methods using a shortcut on Eclipse. This will create a method in the test classes for each method to be tested in the classes to be tested. Next, test cases were invented for each method so that boundary cases are covered. Once this is done, the test cases are coded. If necessary, a Mocker class is used as a substitute for inputs where we don’t have access to the actual class. After all the test cases are coded, the tests are run and the results recorded.

The benefit of using mocking is that limit the dependencies of a test. It allows for you to test a class independently even when it depends on another class. This makes the scope of the test smaller. A drawback is that the tests that use mocking are made for specific implementation of the methods. This might cause you to have to also change the tests when you change the code. If you do not, it might keep passing tests that it should not be.

# 3 Test cases developed
Ryan Sommerville: Formatted and put together most of the report. 
Eric Renno: Created test cases and worked on the report.
Quinn Ledingham: Created test cases and implemented them in JUnit
Kaumil Patel: 


// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
