# Contact Api Spec

## Create Contact

Endpoint :  POST /api/contacs

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

'''json
{
    "firstname" : "user",
    "lasttname" : "user",
    "email" : user@example.com",
    "phone" : "2389472389472"
}
'''

Response Body (Success):

'''json
{   "data" : {
        "id" : "random string",
        "firstname" : "user",
        "lasttname" : "user",
        "email" : user@example.com",
        "phone" : "2389472389472"
    }
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "email format invalid, phone format invalid, ..."
}
'''

## Update Contact

Endpoint : PUT /api/contacts/{idContacts}

Request Header :
 
- X-API-TOKEN : Token (Mandatory)

Request Body : 

'''json
    "firstname" : "user",
    "lasttname" : "user",
    "email" : user@example.com",
    "phone" : "2389472389472"
}
'''

Response Body (Success):

'''json
{ 
    "data" : {
        "id" : "random string",
        "firstname" : "user",
        "lasttname" : "user",
        "email" : user@example.com",
        "phone" : "2389472389472"
    }
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Email format invalid, phone format invalid, ..."
}
'''

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

Response Body (Success):

'''json
{ 
    "data" : {
        "id" : "random string",
        "firstname" : "user",
        "lasttname" : "user",
        "email" : user@example.com",
        "phone" : "2389472389472"
    }
}
'''

Response Body (Failed, 404) :

'''json
{
    "errors" : "Email format invalid, phone format invalid, ..."
}
'''

## Search Contact

Endpoint : GET /api/contacts

Query param : 

- nama : string, first name or last name, usinga like query, optional
- phone : string, contact phone, using like query, optional
- email : string, contact phone, email like query, optional
- page : Integer, start from 0, default 10
- size : Integer, default 10

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

Response Body (Success):

'''json
{ 
    "data" : {
        "id" : "random string",
        "firstname" : "user",
        "lasttname" : "user",
        "email" : user@example.com",
        "phone" : "2389472389472"
    }
},
"paging" : {
    "currentPage" : 0,
    "totalPage" : 10,
    "size" : 10
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Unauthorized"
}
'''

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory) 

Request Body : 

Response Body (Success):

'''json
{
    "data" : "ok"
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Contacts is not found"
}
'''