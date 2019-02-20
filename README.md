##GALAXY MERCHANT TRADING GUIDE
##Assumption
- Silver/Gold/Iron/Credits and all Roman characters is case sensitive for simple implementation (we could handle case insensitive by update the regex pattern)
- User interact with system via commandline console
- User can change the assignment anytime by give new input
##Solution approach
Patterns using:
- Singleton pattern
- Facade pattern: using for separate processing different sentence from user input

Ideally the system will interact with user via console, system will detect
user input type to call appropriate processor to handle.

##Compile and running
Require
- Java 8 installation require
- Maven 3 installation require

To run application in IDE please start GalaxyMerchantApplication.java.

Use the below commands to build and run application:

```mvn package``` 

A jar package name *tulh-galaxy-merchant-1.0-SNAPSHOT.jar* will be place in target/ folder

Command to start application:

```java -jar tulh-galaxy-merchant-1.0-SNAPSHOT.jar```

To execute all the test cases:
```mvn test```