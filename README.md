## best-restaurants
Search API

### GET http://localhost:8080/restaurants

#### Valid query parameters (all parameters are optional):

Name | Type | Description
------ | ---- | -----------
restaurant_name | String | Name of the restaurant
distance | Integer | 1 - 10 miles
price | Integer | $10 - $50 per person
costumer_rating | Integer | 1 - 5 stars
cuisine_name | String | American,Chinese,Thai,Italian,French,Japanese,Turkish,Korean,Vietnamese,Indian,Spanish,Greek,Mexican,Malaysian,African,German,Indonesian,Russian,Other


If the parameter name or the value passed are incorrect, the API will return an error with the problem.
