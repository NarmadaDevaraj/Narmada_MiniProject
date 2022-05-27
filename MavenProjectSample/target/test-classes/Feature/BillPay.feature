Feature: Bill Pay
Background: User Login with valid credentials
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   And User enters UserName as "john" and Password as "demo"
   And Click on Login
   Then Page Title should be "ParaBank | Accounts Overview"
  
 Scenario: Bill Pay 
   Given User click on Bill Pay
   When Page Title should be "ParaBank | Bill Pay"
   And User enters the Payee Name as "Narmada" 
   And User enters Address as "Medahalli" and city as "Bangalore"
   Then User enters state as "Karnataka" and Zip code as "560049"
   And User enters the phone number as "9843915528"
   And User enters the Account as "13344"
   Then Verify the Account as "13344"
   And User enters the amount as "1000"
   And User select the From account as "13344"
   And Click on Send Payment
   When Page Title should be contains "Bill Payment Complete"

Scenario: Bill Pay Error Messages Validation 
   Given User click on Bill Pay
   When Page Title should be "ParaBank | Bill Pay"
   And Click on Send Payment
   Then User verify error Msg as "Payee name is required." for empty PayeeName
   And User verify error msg as "Address is required." for empty payeeAddress
   And User verify error msg as "City is required." for empty payeeAddressCity
   And User verify error msg as "State is required." for empty payeeAddressState
   And User verify error msg as "Zip Code is required." for empty payeeAddressZip
   And User verify error msg as "Phone number is required." for empty payeePhoneNumber
   And User verify error msg as "Account number is required." for empty payeeAccountNumber
   And User verify error msg as "Account number is required." for empty payeeVerifyAccountNumber
   And User verify error msg as "The amount cannot be empty. "  for empty payeeAmount

Scenario: Bill Pay - Verify Invalid and Mismatch error message 
   Given User click on Bill Pay
   When Page Title should be "ParaBank | Bill Pay"
   And User enters the Payee Name as "Narmada" 
   And User enters Address as "Medahalli" and city as "Bangalore"
   Then User enters state as "Karnataka" and Zip code as "560049"
   And User enters the phone number as "9843915528"
   And User enters the Account as "abcde"
   Then Verify the Account as "13344"
   And User enters the amount as "1000"
   And User select the From account as "13344"
   And Click on Send Payment
   When Page Title should be "ParaBank | Bill Pay"
   And Verify the invalid accout id error as "Please enter a valid number."
   And Verify the mismatch verify account id as "The account numbers do not match."
   Then Verify the Account as "abcde"
   And Click on Send Payment
   And Verify the invalid accout id error as "Please enter a valid number."
   And Verify the invalid verify account id as "Please enter a valid number."
   
   
   