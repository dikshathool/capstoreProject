Feature: Managing Admin Inventory
Background:
	Given Admin has loaded the Application in the browser
When Admin enter valid email and valid password
               And click on login button
               Then admin should get navigated to admin home page

Scenario: Admin Can Add new Product Into Inventory  
	   Given Admin on Admin Home Page
          	   When Admin clicks on add product button
          	   And Admin Adds all the product Information
          	   And Admin Clicks on add product button 
          	   Then show all product page must be displayed

Scenario: Admin can Update a product information
   Given Admin on Admin Home Page
          	   When Admin clicks on update product button
           	   And Add information to update a particular product
           	   And Click on update button
           	   Then show all product page must be displayed

Scenario: Admin can remove the product from the show all product list
	   Given Admin on Admin Home Page
           	   When Admin clicks on get all product button
          	    Then It should show all the products
          	    When Admin clicks on remove button for a particular product
          	    Then show all product page must be displayed