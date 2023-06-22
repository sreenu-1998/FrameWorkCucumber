@Test2

Feature: Add all items to cart and checkout one after one

Scenario Outline: Checkout all items
Given user logs in to application with valid credentials
And adds <Item> to the cart.
And clicks on cart icon
And clicks on checkout 
When user provide "Srinivas" , "Reddy" and "560035" 
And clicks on Continue and Finish
Then Order is placed successfully

Examples:
|Item|
|1|
