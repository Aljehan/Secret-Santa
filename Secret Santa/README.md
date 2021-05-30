##**Build, run and test instructions:**
In order to run the app please go to the file repository in bash terminal and execute the following command.

"./mvnw spring-boot:run"

This will run it from Maven directly using the Spring Boot Maven plugin.

you can then access the web application in a local host by copying "http://localhost:8080/" to the browser.

The tool I have used for this assignment is Maven. you dont need to do anything as the mvnw.cmd and MavenWrapperDownloader.java will download it for you.

##**Test instructions:**
After opening the web page in the local host click the START! button. you can then add the employees and delete them via the shown interface. then click on generate matches to get the result. 

The area i chose not to test or involve in this solution at all is the employee's email address. as no emails would be sent to matching people, nor am I checking for duplicate employees. i will talk about the email portion of the problem more in the ** if I had more time ** section.

##**Design decisions and trade-offs:**
I wanted to have a very easy simple and reusable application. My first choice of design was to have a web page with clear instruction that would allow you to add or remove employees. so front end tools were enough for the UI. i used HTML5 and CSS for the UI.

In order to create id for employees and add delete and generate matches and all necessary back end development I have used the Spring frame work which uses Java. It facilitates good programming practice such as programming using interfaces instead of classes. its a great framework to create high performing, reusable, easily testable code and it has a clear documentation as well as big community to help with problems.

I have used Spring MVC since it follows the Model-View-Controller design pattern.

As for data base used to store employees after they are added H2 Databases was my option.as it is a very fast and can support JDBC API. However, it is not very stable compared to other databases and can make you encounter bugs easily. but since the implementation is simple and doesn't require a large data set H2 was good for this assignment.

For template engine Thymeleaf was used.

A lot of these tools are written in Java and are very compatible with the Spring framework. i wanted to heavily focus on the back end side of this project using java since i wanted to take this opportunity to learn more about java back ened and widen my skill tools.


##**Rough edges:**
The main problem I have faced while testing is when you have an odd number of employees in the website it get matched with no one leaving an error. my first fix for the problem is to not show the left out employee at all. but then i decided to pair the left out employee with "Nobody". perhaps it is my understanding of the secret santa is flaw. but implementing a random matchmaking with odd number of people was my biggest challenge.


##**If I only had more time:** 
I would make the app used in a large scale company with thousands of employees. which would require a better database management tool than h2. MySQL would be my choice for that. each employees must have an email associated with them to prevent duplicates. and when you add an employee to the data base they stay there even when the service goes offline. I would also implement a logging in and registration for the manager so no one has access to the matchmaking or the employees data base. and finally, i would send an email to employees informing them who they should buy the gifts to.

s