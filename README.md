# Spring Boot JWT Web API

> ### Spring boot + Hibernate + JWT  codebase containing real world examples (CRUD, auth, advanced patterns, etc) that adheres to the spec and API.

# *Db* Schema 

[![schema](.github/img/er_diagram.png)](https://site.ishakdas.dev/)

The basic logic of this Rest API is mostly based on posts and users.
What can be added to a post?
- Tag
- Comment
- Category

Users registered to the application will be able to share posts.

# How is JWT Token used ?

Users will be able to receive tokens while signing up and logging in.
In addition, after the token expires, it will check during the usage phase and generate new tokens.

# Hibernate

PostgreSql was used in the web service.
The tables and relationships to use were created with Hibernate.
Extremely good conditioning was used with the Hibernate Criteria feature.

# Unit Test

    /register
    /authenticate
    /hello
    
All Routes

Permission

    /helloadmin

Used without tokens

    /authenticate
    /register
    /getResponse
    /refreshtoken
    /home
    /blog
    /blog/{slugName}
    
    
    
    
# You can run and open terminal
    curl http://localhost:8080/blog
