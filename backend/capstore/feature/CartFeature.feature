Feature: Managing Cart Features
Scenario: User can add product into cart
	  Given User has loaded the application in the browser
	   When User Click on the product to be added 
	   And Click on add to cart button  
	   Then  Required product should be added to the cart

Scenario: User Can delete product from cart
	   Given User has loaded the application in the browser
	   When User clicks on show all cart products button
          	    Then It should show all cart products
          	    When User clicks on remove button for a particular product
          	    Then The product should get removed
