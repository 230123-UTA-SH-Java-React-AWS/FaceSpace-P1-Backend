# FaceSpace - Welcome to the New Frontier of Social Media!

## Description
FaceSpace is a social media app that allows you to create posts, comment on them, mark them with Likes, and follow other users of one's choice. It has been split between two repositories for ease of development; what you are currently viewing is the backend repository. For the frontend code, please go [here](https://github.com/230123-UTA-SH-Java-React-AWS/FaceSpace-P1-Frontend). 

The backend was built with Java as the programming language of choice, using the Spring Framework to reduce time spent on configuration and allow more focus on backend business logic. Spring JPA Data specifically was one of our most powerful tools as an ORM, since it reduced our need to manually write out our SQL statements. The database of choice is PostgreSQL, using the online database ElephantSQL as an easy way to share communal data between developers. 

### Collaborators 
- [Sean Bellinger](https://github.com/sean-bellinger)
- [Sheryl Hu](https://github.com/reversedentistry)
- [Andrew Yang](https://github.com/D-Programming-Man)
- [Josh Yang](https://github.com/jtbyang)

### Technologies
- Java 
  - Maven
- Spring Core Framework
  - Spring Boot
  - Spring JPA Data
- PostgreSQL
  - ElephantSQL

## Installation Instructions
Cloning and opening this repository should automatically have Maven installing the appropriate dependencies into the project. Before running, check the application.properties file within the resources folder to make sure the correct URLs for your database are set up. 

## Usage Instructions
For the full experience of using the app, we highly recommend downloading the frontend code. If used in conjunction, run this backend through its main application and activate the front end with `npm start` within its terminal. If only this backend code is used, you must use cURL or an API client (Insomnia, Postman, etc.) to query and manipulate data. Further instructions in this section will be for those who are only using the latter.

Make sure to run the application first. The URL to run requests through will begin with `http://localhost:8080/api`. To create a new user, make a POST request to the URL `http://localhost:8080/api/users`. Make sure JSON format is chosen for the request body and enter an email address, a password, a given name, and a surname as follows: 
```agsl
{
    "emailAddress": "[your entry here]",
    "password": "[your entry here]",
    "givenName": "[your entry here]",
    "surname": "[your entry here]"
}
```
You do not need to enter an ID for your entries since they are auto-generated.

Creating a post is similar except the keys are `writtenText` and `profileId`, the latter of which is the ID of an existing user within the database, and the URL to use is `http://localhost:8080/api/posts`. 

To create a comment, the keys are `writtenText`, `profileId`, and `postId`, the last of which is the ID of an existing post. The URL for requests is `http://localhost:8080/api/comments`. 

To add a like, the keys are `profileId` and `postId`, and the URL for requests is `http://localhost:8080/api/likes`. Please note that the response for this POST request will return the total number of likes of the specified post.

## License 
This project is MIT licensed. 