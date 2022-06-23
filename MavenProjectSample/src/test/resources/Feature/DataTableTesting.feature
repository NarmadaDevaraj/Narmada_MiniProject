Feature: Login data

Scenario: Successful Login with data tables
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   When User enters UserName and Password
   |Username|Password|
   |john    |demo |
   And Click on Login button
   Then Page Title should be "ParaBank | Accounts Overview"
   When User click on log out link
   Then Page Title should be "ParaBank | Welcome | Online Banking"
   And Close the browser