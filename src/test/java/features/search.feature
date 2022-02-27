Feature: Search and place order for the product

@ProductValidation
Scenario Outline: Price validation.
Given The user is on bigbasket homepage
When The user search navigates to fruits and vegetable section
And Searches for <Name>
Then The user should get the price of the product 
When The user searches navigates to offers page
And if product is available on the offers page
Then The user should get the price of the product on offers page
And The product name and price on offers page should be same as seen on homepage

Examples:
| Name     |
| tomato   |
| perilla  |