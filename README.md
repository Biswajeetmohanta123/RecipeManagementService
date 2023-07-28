<h1 align="center"> 
🏡Recipe Management Service API</h1>
This is a API project for `User` to show recipes with `other users` for cooking. Here I've used athentication for `User`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")

---
## Browser / Tools
![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")
---

### Data flow
1. Model
2. Dtos
3. Controllers
4. Services
5. Repositories

- ### Database
    I have used `MySQL` database in this project. And used `SpringDataJPA`.
---
## Datastructures
- `ArrayList<>`
---
---
## Database Used
- `MySQL database : recipeManagement`
---
## Summary
This API is a `Spring Boot` project that is about users making recipes. In this project request is sent from the client on HTTP in JSON body or from path variable and stored in object then response is sent back from the server by JSON format to the client. Kindly refer application.properties to build connection with mysql database.

End points:
  
    - ##### /get-AllRecipe
    - ##### /add-recipe
    - ##### /update-IngredientsByRecipeId
    - ##### /delete-ByRecipeName
    - ##### /get-AllRecipeBySpecificUser
    - ##### /signUp
    - ##### /signIn
    - ##### /get-AllUsers
    - ##### /delete-UserByEmail
    - ##### /logout

