# Adventure Game
The repository that you clone contains a simple Maven project with two classes: `Location.java` and `Driver.java`.

> Upon cloning the repo make sure you run `mvn clean install` within the root directory.

Currently the user is able to run `Driver`and it opens up a simple console-driven program that emulates the original [*Colossal Cave Adventure Game*](https://en.wikipedia.org/wiki/Colossal_Cave_Adventure).  There are 5 rooms, each with their respective exits which the user can navigate through.  

Below is a diagram of the Game Map:

<img src="img/image.png" width="800px">

<br>

## Challenge
Convert the existing project to a **Spring Application** complete with an api layer that allows the user to send get/post requests and recieve their updated location in the body of the HTTP response.

- 
