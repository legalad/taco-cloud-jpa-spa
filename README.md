# Taco Cloud ![icons8-spring-boot-48](https://user-images.githubusercontent.com/109519711/229430886-455159ed-6663-4076-8c3d-bb30689a6a8b.png) ![icons8-postgresql-48](https://user-images.githubusercontent.com/109519711/229431509-a0d02ea3-381d-43b9-a422-400398d3ab0e.png)

Taco Cloud is a simple restaurant website created with spring and postgres.

## Features
- register & login 
- design & order form 
- responsive layout (pc & mobile)
- data validation
- form autocomplete basen data from your account
- exception hanling (examples: input non-compliant data results in proper display info in form)
- postgres db

## Screenshots
### menu
![image](https://user-images.githubusercontent.com/109519711/230630775-361ae13c-70db-4dbc-9e5f-3a7976bb75de.png)
### registration & login
![image](https://user-images.githubusercontent.com/109519711/230630647-bbb5315d-0671-4f41-96bf-0b9e76a6addd.png)
![image](https://user-images.githubusercontent.com/109519711/230631488-58762c44-735f-4d79-87fe-8b8ce32e0112.png)
### design taco
![image](https://user-images.githubusercontent.com/109519711/230633593-c6741793-5f0b-4aed-9054-37a3a1018939.png)
### order taco
![image](https://user-images.githubusercontent.com/109519711/230633945-326f2c6e-c196-47aa-a324-22977834b36b.png)

## database
### diagram
![image](https://user-images.githubusercontent.com/109519711/230634913-c7dfcb2e-68d3-4c2b-bf5a-34da1a72fd6e.png)
### sql script
![database script](https://github.com/legalad/legalad/blob/main/taco)
### futher actions
1. run this script in pgadmin,
2. insert some ingredients,
3. clone taco cloud repo,
4. check in application.properties your datasource url and credentials (may need to be changed if you don't use default settings)
```
spring.datasource.url=jdbc:postgresql://localhost:5432/taco
spring.datasource.username=postgres
spring.datasource.password=postgres
```
5. run TacoCloudApplication,
6. in browser enter http://localhost:8080/

## References
Project ispired by Craig Walls - Spring in Action (ISBN 9781617294945).

Original project: [github - spring in action](https://github.com/habuma/spring-in-action-5-samples)

## Authors
- [@legalad](https://www.github.com/legalad)
