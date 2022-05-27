Feature: Transfer Fund
Background: User Login with valid credentials
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   And User enters UserName as "john" and Password as "demo"
   And Click on Login
   Then Page Title should be "ParaBank | Accounts Overview"
  
 Scenario: Transfer Fund from one account to another
   Given User click on Transfer Funds
   When Page Title should be "ParaBank | Transfer Funds"
   When User enter the Amount as "1000"
   And User enters From Account as "13344" and To Account as "13344"
   Then Click on Transfer Button
   When Page Title should be contains "Transfer Complete!"
   And Verify Amount should be "$1000.00"
   And Verify From account should be "13344" and To account should be "13344"
 