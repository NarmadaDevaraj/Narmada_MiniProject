Feature: Openning  New Account
Background: User Login with valid credentials
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   And User enters UserName as "john" and Password as "demo"
   And Click on Login
   Then Page Title should be "ParaBank | Accounts Overview"
Scenario: Open a New Account
   Given User click on New Account 
   When Page Title should be "ParaBank | Open Account"
   When User select the Account Type as "<AccountType>"
   And User select Exsisting Account number as "13344"
   And Click on OPEN NEW ACCOUNT button
   When Page Title should be contains "Account Opened!"
   And click on Account Number
   When Page Title should be contains "Account Details"
   And Verify Account Type as "CHECKING"
   And Verify New Account ID
   Then User select Activity period as "February" and Type as "Credit"
   And User click on GO
   
   Examples:
   | AccountType |
   | CHECKING |
   | SAVINGS |
   