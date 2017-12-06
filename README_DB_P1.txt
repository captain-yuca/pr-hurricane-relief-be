In order to access this system go to:

localhost:8080

Here you will see all the entities of the system.
---------------------------------------------------------------------------
In order to access a specific entity, substitute in the name at EntityName

GENERIC EXAMPLE:localhost:8080/EntityName
ACTUAL  EXAMPLE:localhost:8080/users

----------------------------------------------------------------------------

In order to find all the possible searches inside said entity, go to

GENERIC EXAMPLE:localhost:8080/EntityName/search
ACTUAL  EXAMPLE:localhost:8080/users/search

Here you will see a list of all the findBy methods you can use in said
entity. 

----------------------------------------------------------------------------

In order to carry out any of the displayed searches go to

GENERIC EXAMPLE:localhost:8080/EntityName/search/findByArgument?argument=myArgument
ACTUAL  EXAMPLE:localhost:8080/users/search/findByFName?fName=Herbert
substituting in the appropiate fields. 

----------------------------------------------------------------------------

If using a method that searches more than one field, the proper manner
to separate them is

GENERIC EXAMPLE:localhost:8080/EntityName/search/findByArgument1AndArgument2?argument1=myArgument1&argument2=myArgument2
ACTUAL  EXAMPLE:localhost:8080/users/search/findByFNameAndLName?fName=Herbert&lName=Perez


----------------------------------------------------------------------------

If you know the data inside the system, you can also navigate it using the 
internal fields of the entities.

GENERIC EXAMPLE:localhost:8080/EntityName/PrimaryKey
ACTUAL  EXAMPLE:localhost:8080/users/1

this way you can get the information about a specific item without having to do searches. 
----------------------------------------------------------------------------

