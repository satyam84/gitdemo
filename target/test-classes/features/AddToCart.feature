Feature: Checkout feature

@CheckOut
Scenario: Checkout feature validation
Given The user is on Bigbasket homePage
Then User has to log in
When User searches for the product
#And Clicks on the desired product
And Adds some quantity of the product to the basket
Then The product is added to the basket
And The user should proceed to checkout
