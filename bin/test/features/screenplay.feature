Feature: Buying in Mercado libre
  Me as Mercado libre user
  Wannts to buy a new bike
  To use

  @tag1
  Scenario: Estimate bike in Mercado libre
    Given I am in the main page of Mercado libre
    When I search for "bicicleta GW" in the web page
    Then I would see "bicicleta GW" like a title of the searh 

	@tag2
	Scenario: Estimate bike in Mercado libre logged in the principal page
		Given I am loggen in Mercado Libre
		When I search for "bicicleta GW" used in the web page
		Then I would see that the tag Usado is present