Feature: Managing Admin Inventory 
Background: 
	Given Admin has loaded the Application in the browser 
	When Admin Clicks on login Link
	And Admin enter valid email Id
	And Admin enter valid password 
	And click on login button 
	Then admin should get navigated to admin home page 
	
Scenario: Admin Can Add new Product Into Inventory 
	Given Admin on Admin Home Page 
	When Admin clicks on add product button 
	And Admin enter product name in productName textbox
	And Admin enter product brand in productBrand textbox
	And Admin enter price in productPrice textbox
	And Admin enter product category in productCategory textbox
	And Admin enter product Quantiy in productQuantity textbox
	And Admin enter product Image in productImage textbox
	And Admin enter discount on product in productDiscount textbox
	And Admin enter product discount Expiry Date in productDiscoutExpireDate textbox
	And Admin enter email Id in email textbox
	And Admin Clicks on add product button 
	Then show all product page must be displayed 
	
Scenario: Admin can Update a product information 
	Given Admin on Products Page
	When Admin clicks on update product button 
	And enter price in productPrice textbox
	And enter product Quantiy in productQuantity textbox
	And enter discount on product in productDiscount textbox
	And Click on update button 
	Then show all product page must be displayed 
	
Scenario: Admin can remove the product from the show all product list 
	Given Admin on Products Page
	When Admin clicks on Products button  
	And Admin clicks on delete button for a particular product 
	Then show all products page must be displayed