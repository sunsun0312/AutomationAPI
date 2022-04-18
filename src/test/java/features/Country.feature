Feature: Verify Country API

@Add
Scenario Outline: Verify if Country is successfully added using AddAPI
	Given Add payload with "<code>" "<name>"
	When user calls "Add" using "POST" http method
	Then the API returns statusCode with 200
	And the "id" in response is returned
	
Examples:
	| code   |  name   |
	| AMM    |  Zambia |
	
@Fill
Scenario: Verify if Country can be retrieved by id using GetAPI
	Given Get payload
	When user calls "Fill" using "GET" http method
	Then the API returns statusCode with 200

	
@Update
Scenario Outline: Verify if Country is updated using UpdateAPI
	Given Update payload with "<code>" "<name>"
	When user calls "Update" using "PUT" http method
	Then the API returns statusCode with 200
	
Examples:
	| code   |  name   |
	| CQQQ   |  Antarctica |
	
@Delete
Scenario: Verify if Country is deleted using DeleteAPI
	Given Delete payload
	When user calls "Delete" using "DELETE" http method
	Then the API returns statusCode with 200
	

	

	
	