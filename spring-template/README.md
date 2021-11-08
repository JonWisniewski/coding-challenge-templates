# Main Goal
This coding challenge is designed to assess a candidate’s level of experience with building a Backend RESTful application.

## Backend Engineer Coding Challenge
For this challenge, you will be building a simple API which provides a list of supervisors and accepts a registration to receive notifications from a given supervisor.

### Server Specifications
Please build an application that exposes an API that allows an application to retrieve a list of supervisors and submit personal information.
Your application must include the following endpoints:

**GET/api/supervisors**
- When this endpoint is hit, a call is made to GET https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers to pull down a list of managers.
- The endpoint should take the response payload from AWS and format it to return:
  - A list of supervisor strings formatted as follows: “jurisdiction - lastName, firstName”
  - Supervisors within the endpoint response payload should be sorted in alphabetical order first by jurisdiction, then by lastName and firstName.
  - Numeric jurisdictions should be excluded from the response.

**POST /api/submit**
- The endpoint should expect to be provided the following parameters by means of your preferred content type:
  - firstName
  - lastName
  - email
  - phoneNumber
  - supervisor

- The submitted data above should be printed to the console upon receiving the post request.
- If firstName, lastName, or supervisor is not provided, the endpoint should return an error response. These are required parameters.
- The user of your endpoint should have the option to leave out email and phoneNumber when they submit without issue. They are not required for submission.

# Running locally with gradle
1. First go to https://github.com/JonWisniewski/coding-challenge-templates and click the green button that says "Code".
2. After clicking the button, please select "Download ZIP".
3. Extract the downloaded file on to the desktop, creating a folder called "coding-challenge-templates-main".
4. Navigate in to the folder and copy the folder location.
```
C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template <- (For Windows)
```
5. Open up command prompt and navigate to the correct directory:
```
cd C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template
```
6. Enter the following in to the command prompt to build the application:
```
gradle build
```
7. Enter the following in to the command prompt to run the application:
```
gradle bootRun
```
8. To make sure the application is indeed running, download PostMan to test the GET and POST endpoints: https://www.postman.com/downloads/
9. Once PostMan is installed, please open the application. When it is opened, select GET and paste this url to the right of it: http://localhost:8080/api/supervisors and click the blue button that says "Send". This is what the output should look like:
```
[
    "b - Cremin, Elijah",
    "b - Denesik, Kobe",
    "b - Gerhold, Jaquan",
    "b - Tremblay, Terrell",
    "c - Hermiston, Laverna",
    "d - Braun, Ida",
    "e - Raynor, Pascale",
    "e - Zieme, Donny",
    "g - Ziemann, Clifton",
    "h - Hoppe, Lisa",
    "i - Bartell, Angelina",
    "i - Bechtelar, Bruce",
    "i - Hane, Kathlyn",
    "j - Wisozk, Gunner",
    "k - Jacobi, Lucious",
    "l - Becker, Anastacio",
    "l - Gutmann, Rodrick",
    "l - McLaughlin, Dorothea",
    "m - Huels, Lavern",
    "n - Schulist, Cali",
    "p - Wyman, Kirsten",
    "q - Collier, Ezequiel",
    "q - Larson, Makayla",
    "r - Runolfsson, River",
    "t - Lockman, Garnett",
    "t - Volkman, Jett",
    "u - Beer, Dolores",
    "u - Deckow, Lavon",
    "u - Lehner, Magdalena",
    "u - Olson, Karson",
    "x - Brakus, Zena",
    "x - D'Amore, Maribel",
    "x - Schamberger, Lydia",
    "y - Sauer, Rashad",
    "z - Oberbrunner, Ricky"
]
```
10. After the GET method, let us try the POST endpoint. Change the method from GET to POST in the dropdown, and replace the url below with this: http://localhost:8080/api/submit
11. For the POST method, we have to attach a body to the request. Click below the url on a word that says "Body". On the body screen, click "raw" then select the dropdown arrow and click "JSON".
12. This first request that will be sent, will send back a 201 status code and a output in the command prompt similar to this:
```
User [firstName=Jonathan, lastName=Wisniewski, email=jonathanWisniewski@gmail.com, phoneNumber=(330) 555-5555, supervisor=a - Heller, Robbie]
```
13. Click inside the empty white space below where you selected "JSON" and paste this JSON so that you will return the information above. Once you are done, click "Send" and see the response. 
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
14. Hopefully the response looked like the JSON above. After making sure you were successful, let us try to remove some of the required fields to create an error response. The fields that will need to be removed are "firstName", "lastName", and "supervisor".
15. Replace the JSON body with the information below to receive the output in PostMan.

Example #1
```
{
  "firstName": "",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value"
    ]
}
```
Example #2
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value"
    ]
}
```
Example #3
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:38:31",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #4
```
{
  "firstName": null,
  "lastName": null,
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:39:53",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #5
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "",
	"lastName": "",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:40:46",
    "defaultMessages": [
        "Supervisors first name is missing value",
        "Supervisors last name is missing value",
        "Supervisors jurisdiction is missing value"
    ]
}
```
16. When you are done testing all the potential errors, please enter the information below to stop the application: 
```
gradle -stop
```
# Running with docker
To help ensure consistently correct startup across multiple platforms, you may choose to use Docker to containerize your application.  Installation steps for docker can be found on their main page. https://docs.docker.com/engine/install/

1. First go to https://github.com/JonWisniewski/coding-challenge-templates and click the green button that says "Code".
2. After clicking the button, please select "Download ZIP".
3. Extract the downloaded file on to the desktop, creating a folder called "coding-challenge-templates-main".
4. Navigate in to the folder and copy the folder location.
```
C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template <- (For Windows)
```
5. Open up command prompt and navigate to the correct directory:
```
cd C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template
```

6. With Docker installed, you can build your a new image. This build needs to be run after any changes are made to the source code.
```
docker build --tag=spring-template:latest .
```

 7. After the image builds successfully, run a container from that image.
```
docker run -d --name spring-template -p8080:8080 spring-template:latest
```
8. To make sure the application is indeed running, download PostMan to test the GET and POST endpoints: https://www.postman.com/downloads/
9. Once PostMan is installed, please open the application. When it is opened, select GET and paste this url to the right of it: http://localhost:8080/api/supervisors and click the blue button that says "Send". This is what the output should look like:
```
[
    "b - Cremin, Elijah",
    "b - Denesik, Kobe",
    "b - Gerhold, Jaquan",
    "b - Tremblay, Terrell",
    "c - Hermiston, Laverna",
    "d - Braun, Ida",
    "e - Raynor, Pascale",
    "e - Zieme, Donny",
    "g - Ziemann, Clifton",
    "h - Hoppe, Lisa",
    "i - Bartell, Angelina",
    "i - Bechtelar, Bruce",
    "i - Hane, Kathlyn",
    "j - Wisozk, Gunner",
    "k - Jacobi, Lucious",
    "l - Becker, Anastacio",
    "l - Gutmann, Rodrick",
    "l - McLaughlin, Dorothea",
    "m - Huels, Lavern",
    "n - Schulist, Cali",
    "p - Wyman, Kirsten",
    "q - Collier, Ezequiel",
    "q - Larson, Makayla",
    "r - Runolfsson, River",
    "t - Lockman, Garnett",
    "t - Volkman, Jett",
    "u - Beer, Dolores",
    "u - Deckow, Lavon",
    "u - Lehner, Magdalena",
    "u - Olson, Karson",
    "x - Brakus, Zena",
    "x - D'Amore, Maribel",
    "x - Schamberger, Lydia",
    "y - Sauer, Rashad",
    "z - Oberbrunner, Ricky"
]
```
10. After the GET method, let us try the POST endpoint. Change the method from GET to POST in the dropdown, and replace the url below with this: http://localhost:8080/api/submit
11. For the POST method, we have to attach a body to the request. Click below the url on a word that says "Body". On the body screen, click "raw" then select the dropdown arrow and click "JSON".
12. This first request that will be sent, will send back a 201 status code and a output in the docker command prompt similar to this:
```
User [firstName=Jonathan, lastName=Wisniewski, email=jonathanWisniewski@gmail.com, phoneNumber=(330) 555-5555, supervisor=a - Heller, Robbie]
```
13. Click inside the empty white space below where you selected "JSON" and paste this JSON so that you will return the information above. Once you are done, click "Send" and see the response. 
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
14. Hopefully the response looked like the JSON above. After making sure you were successful, let us try to remove some of the required fields to create an error response. The fields that will need to be removed are "firstName", "lastName", and "supervisor".
15. Replace the JSON body with the information below to receive the output in PostMan.

Example #1
```
{
  "firstName": "",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value"
    ]
}
```
Example #2
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value"
    ]
}
```
Example #3
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:38:31",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #4
```
{
  "firstName": null,
  "lastName": null,
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:39:53",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #5
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "",
	"lastName": "",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:40:46",
    "defaultMessages": [
        "Supervisors first name is missing value",
        "Supervisors last name is missing value",
        "Supervisors jurisdiction is missing value"
    ]
}
```
16. When you are done testing, stop the server and remove the container.
```
docker rm -f spring-template
```

# Running with docker-compose

1. First go to https://github.com/JonWisniewski/coding-challenge-templates and click the green button that says "Code".
2. After clicking the button, please select "Download ZIP".
3. Extract the downloaded file on to the desktop, creating a folder called "coding-challenge-templates-main".
4. Navigate in to the folder and copy the folder location.
```
C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template <- (For Windows)
```
5. Open up command prompt and navigate to the correct directory:
```
cd C:\Users\YourComputerName\Desktop\coding-challenge-templates-main\spring-template
```
6. Enter the information below to build the gradle application:
```
docker-compose build
```
7. After the application is built, please enter the following in to the command prompt:
```
docker-compose up
```
8. To make sure the application is indeed running, download PostMan to test the GET and POST endpoints: https://www.postman.com/downloads/
9. Once PostMan is installed, please open the application. When it is opened, select GET and paste this url to the right of it: http://localhost:8080/api/supervisors and click the blue button that says "Send". This is what the output should look like:
```
[
    "b - Cremin, Elijah",
    "b - Denesik, Kobe",
    "b - Gerhold, Jaquan",
    "b - Tremblay, Terrell",
    "c - Hermiston, Laverna",
    "d - Braun, Ida",
    "e - Raynor, Pascale",
    "e - Zieme, Donny",
    "g - Ziemann, Clifton",
    "h - Hoppe, Lisa",
    "i - Bartell, Angelina",
    "i - Bechtelar, Bruce",
    "i - Hane, Kathlyn",
    "j - Wisozk, Gunner",
    "k - Jacobi, Lucious",
    "l - Becker, Anastacio",
    "l - Gutmann, Rodrick",
    "l - McLaughlin, Dorothea",
    "m - Huels, Lavern",
    "n - Schulist, Cali",
    "p - Wyman, Kirsten",
    "q - Collier, Ezequiel",
    "q - Larson, Makayla",
    "r - Runolfsson, River",
    "t - Lockman, Garnett",
    "t - Volkman, Jett",
    "u - Beer, Dolores",
    "u - Deckow, Lavon",
    "u - Lehner, Magdalena",
    "u - Olson, Karson",
    "x - Brakus, Zena",
    "x - D'Amore, Maribel",
    "x - Schamberger, Lydia",
    "y - Sauer, Rashad",
    "z - Oberbrunner, Ricky"
]
```
10. After the GET method, let us try the POST endpoint. Change the method from GET to POST in the dropdown, and replace the url below with this: http://localhost:8080/api/submit
11. For the POST method, we have to attach a body to the request. Click below the url on a word that says "Body". On the body screen, click "raw" then select the dropdown arrow and click "JSON".
12. This first request that will be sent, will send back a 201 status code and a output in the command prompt similar to this:
```
User [firstName=Jonathan, lastName=Wisniewski, email=jonathanWisniewski@gmail.com, phoneNumber=(330) 555-5555, supervisor=a - Heller, Robbie]
```
13. Click inside the empty white space below where you selected "JSON" and paste this JSON so that you will return the information above. Once you are done, click "Send" and see the response. 
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
14. Hopefully the response looked like the JSON above. After making sure you were successful, let us try to remove some of the required fields to create an error response. The fields that will need to be removed are "firstName", "lastName", and "supervisor".
15. Replace the JSON body with the information below to receive the output in PostMan.

Example #1
```
{
  "firstName": "",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value"
    ]
}
```
Example #2
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "Robbie",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "a",
	"lastName": "Heller",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 09:39:37",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value"
    ]
}
```
Example #3
```
{
  "firstName": "",
  "lastName": "",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:38:31",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #4
```
{
  "firstName": null,
  "lastName": null,
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": null
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:39:53",
    "defaultMessages": [
        "First Name field is missing value",
        "Last Name field is missing value",
        "Supervisor field is missing value"
    ]
}
```
Example #5
```
{
  "firstName": "Jonathan",
  "lastName": "Wisniewski",
  "email": "jonathanWisniewski@gmail.com",
  "phoneNumber": "(330) 555-5555",
  "supervisor": {
  	"firstName": "",
	"id": "1",
	"identificationNumber": "96188a56-1f92-4876-8df3-d8761ea5162f",
	"jurisdiction": "",
	"lastName": "",
	"phone": "792.910.1754"
  }
}
```
```
{
    "statusCode": 400,
    "timestamp": "11-08-2021 05:40:46",
    "defaultMessages": [
        "Supervisors first name is missing value",
        "Supervisors last name is missing value",
        "Supervisors jurisdiction is missing value"
    ]
}
```
8. Once you are done with the application, please enter the following in to the command prompt to stop the application:
```
docker-compose down
```
