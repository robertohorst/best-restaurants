## best-restaurants
Search API

#### Installing
Clone the repository: https://github.com/robertohorst/best-restaurants.git

#### GET http://localhost:8080/restaurants

#### Valid query parameters (all parameters are optional):

Name | Type | Description
------ | ---- | -----------
restaurantName | String | Name of the restaurant
distance | Integer | 1 - 10 miles
price | Integer | $10 - $50 per person
costumerRating | Integer | 1 - 5 stars
cuisineName | String | American,Chinese,Thai,Italian,French,Japanese,Turkish,Korean,Vietnamese,Indian,Spanish,Greek,Mexican,Malaysian,African,German,Indonesian,Russian,Other

example: http://localhost:8080/restaurants?price=34&costumerRating=3

If the parameter name or the value passed are incorrect, the API will return an error with the problem.
