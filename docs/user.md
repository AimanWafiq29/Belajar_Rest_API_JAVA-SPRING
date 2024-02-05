# User API Spec

## Register User

- Endpoint : POST /api/users

Request Body : 

...
    json
{
    "username" : "user",
    "password" : "user",
    "name" : "user" 
}
...

Respones Body (Success) : 

...
    json
{
   "data" : "OK"
}
...

Respones Body (failed) : 

...
    json
{
   "errors" : "Username must not blank, ???"
}
...

## Login User

- Endpoint : POST /api/auth/login

Request Body : 

...
    json
{
    "username" : "user",
    "password" : "user",
}
...

Respones Body (Success) : 

...
    json
{
   "data" : {
        "token" : "TOKEN",
        "expiredAt" : 23213123412321 //milliseconds
    }
}
...

Respones Body (failed, 401) : 

...
    json
{
   "errors" : "Username or Password wrong"
}
...

## Get User

- Endpoint : GET /api/users/login/current

Request Header : 

- X-API-TOKEN : Token (Mandatory) 

Respones Body (Success) : 

...
    json
{
   "data" : {
        "username" : "user",
        "name" : "user"
    }
}
...

Respones Body (failed, 401) : 

...
    json
{
   "errors" : "Unauthorized"
}
...

## Update User

- Endpoint : PATCH /api/users/login/current

Request Header : 

- X-API-TOKEN : Token (Mandatory) 

Respones Body : 

...
    json
{
    "name" : "user"
    "password" : "user"
}
...

Respones Body (Success) : 

...
    json
{
   "data" : {
        "username" : "user",
        "name" : "user"
    }
}
...

Respones Body (failed, 401) : 

...
    json
{
   "errors" : "Unauthorized"
}
...

## Logout User

- Endpoint : PATCH /api/auth/logout

Request Header : 

- X-API-TOKEN : Token (Mandatory) 

Respones Body (Success) : 

...
    json
{
   "data" : "OK"
}
...