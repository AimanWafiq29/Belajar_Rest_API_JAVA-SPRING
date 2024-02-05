# Address API Spec

## Create Address

Endpoint :  POST /api/contacs/{idContacts}/addreess

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

'''json
{
    "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
}
'''

Response Body (Success):

'''json
{   "data" : {
   "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
 }
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Address is not found"
}
'''

## Update Adress

Endpoint :  PUT /api/contacs/{idContact}/address/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

'''json
{
    "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
}
'''

Response Body (Success):

'''json
{   "data" : {
   "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
 }
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Address is not found"
}
'''

## Get Address

Endpoint :  GET /api/contacs/{idContact}/address/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)
 
'''json
{
    "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
}
'''

Response Body (Success):

'''json
{   "data" : {
   "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
 }
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Address is not found"
}
'''

## Remove Address

Endpoint :  DELETE /api/contacs/{idContact}/address/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success):

'''json
{   
    "data" : "Ok"
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Address is not found"
}
'''

## List Address

Endpoint :  GET /api/contacs/{idContact}/address/

Request Header :

- X-API-TOKEN : Token (Mandatory)

'''json
{   "data" : [
   "street" : "Jl.Example",
    "city" : "Example",
    "province" : "Example",
    "country" : "Example",
    "postcode" : "Example 2321",
 ]
}
'''

Response Body (Failed) :

'''json
{
    "errors" : "Address is not found"
}
'''