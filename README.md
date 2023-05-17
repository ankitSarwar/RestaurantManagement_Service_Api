<h1 align="center"> RestaurantManagement_Service_Api </h1>

* Tech stack used: Spring Boot, Hibernate, MySQL, OOPs, Postman, Swagger, and Java
>### Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)


* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)

* Implemented CRUD operations with data validation, MySQL database configuration, 
Swagger integration, authentication and established table relationships.
This project is a portal that handles different types of relationships (one-to-one, one-to-many, many-to-one, and many-to-many) between various entities. It provides CRUD (Create, Read, Update, Delete) operations for each model, allowing you to manage the data effectively.

>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.
* **dto** -this layer SignupInput,SignUpOutput,SignInInput,SignInOutput which store the data of user to Authentication.

## Models
The portal includes the following models:

>### Admin-
- adminId -Auto generate Id.
- firstName: first name of Admin.
- lastName :last name of admin.
- email : In which add regex for eamil for admin ex-@admin.restaurant.com.

## AuthenticationToken
Represents an authentication token for a user.

- tokenId (Long): The ID of the token.
- token (String): The token string for authentication.
- tokenCreationDate (LocalDate): The date when the token was created.

>### FoodItem-
 - foodId : Auto generate Id.
 - title : enum which enum is food Name in it.
 - description: description of food.
 - price: price of food.
 - createdDateTime : time of order food.
 - dummyImageUrl : Image of food.

>### FoodTitle
> ENUM create of food name-

  - PIZZA,BURGER, PASTA,SUSHI, SALAD,STEAK, TACO,RAMEN,CURRY,
    SUSHI_BURRITO, SMOOTHIE, ICE_CREAM,CAKE,COFFEE,TEA,PANCAKES,
    WAFFLES, DONUT,CHOCOLATE,PIZZA_ROLLS,FRENCH_FRIES.
    
>### Orders
    - Id : Auto generate Id.
    - quantity :quantity of food order.
    - status : food status.
    - createdDateTime : time of order.
    - foodItem : which food order.
    - user : mapping with User.

>### User
    - userId: Auto generate Id.
    - username
    -  password:
    -  email:
    -  Address:
    -  userContact:


## Controllers and APIs
>### The API endpoints and their usages are as follows:

>### Food Item Endpoints
-  POST /fooditems/create: Create a new food item.
-  GET /fooditems/{id}: Get a food item by its ID.
-  GET /fooditems/all: Get all food items.
-  PUT /fooditems/update/{foodId}: Update a food item.
-  DELETE /fooditems/{id}: Delete a food item.

>### Order Endpoints
-  POST /orders/create: Create a new order.
-  GET /orders/{orderId}: Get an order by its ID.
-  PUT /orders/update: Update an order.
-  DELETE /orders/{orderId}: Delete an order.

>### User Endpoints
-  POST /User/signup: Create a new user.
-  POST /User/signIn: Authenticate a user and generate a token.
-  GET /User/getAll :get All User.
-  PUt /User/Update/{id} : update BY Id.

>### Admin Endpoints 
  - POST /Admin/AddAdmin : to crate admin.
  - GET /Admin/getAllUser :  get all user.
  - GET /Admin/getAllAdmin : get All admin.

>## Project Summary
This project demonstrates the basic usage of Spring Boot  to build a RESTful API for RestaurantManagement. Further enhancements can be made to add authentication and authorization, error handling, etc.


