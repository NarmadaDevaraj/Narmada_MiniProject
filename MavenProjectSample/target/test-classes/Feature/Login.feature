Feature: Login

Scenario: Successful Login with Valid Credentials
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   And User enters UserName as "john" and Password as "demo"
   And Click on Login
   Then Page Title should be "ParaBank | Accounts Overview"
   When User click on log out link
   Then Page Title should be "ParaBank | Welcome | Online Banking"
   And Close the browser
   
   