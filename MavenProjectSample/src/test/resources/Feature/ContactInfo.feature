Feature: UpdateContact
Background: User Login with valid credentials
   Given User Launch Chrome browser
   When User opens URL "https://parabank.parasoft.com/parabank/index.htm"
   And User enters UserName as "john" and Password as "demo"
   And Click on Login
   Then Page Title should be "ParaBank | Accounts Overview"

 Scenario: UpdateContact Info 
   Given User click on Update Contact 
   When Page Title should be "ParaBank | Update Profile"
   And User enters the First Name as "Narmada"
   And User enters the Last Name as "Devaraj" 
   And User enters Customer Address as "brindhavan" and city as "Bangalore"
   Then User enters Customer state as "Karnataka" and Zip code as "560049"
   And User enters the Customer phone number as "9843915528"
   And Click on Update Profile
   When Page Title should be contains "Profile Updated"
   
Scenario: UpdateContact Info -Error Msg validation
   Given User click on Update Contact 
   When Page Title should be "ParaBank | Update Profile"
   And User Clears the First Name Column and verify Error msg as "First name is required."
   And User Clears the Last Name Column and verify Error msg as "Last name is required." 
   And User Clears the Address  Column and verify Error msg as "Address is required."
   Then User Clears the city  Column and verify Error msg as "City is required."
   And User Clears the state  Column and verify Error msg as "State is required."
   And User Clears the Zip code Column and verify Error msg as "Zip Code is required."
   And Click on Update Profile
   When Page Title should be contains "ParaBank | Update Profile"   