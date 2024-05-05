Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

  Background:
    Given I landed on Ecommerce page


Scenario Outline: Positive Test of Submitting the order

  Given Logged in with username <name> and password <password>
  When I add product <productname> to cart
  And Checkout <productname> and submit the order
  Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

  Examples:
    | name                      | password  | productname   |
    | shanmukbayaneni@gmail.com | Shannu123 | IPHONE 13 PRO |
