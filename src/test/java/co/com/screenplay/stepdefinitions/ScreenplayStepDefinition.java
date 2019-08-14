package co.com.screenplay.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.com.screenplay.questions.CompareSearchPageTitle;
import co.com.screenplay.questions.ConfirmUsedTag;
import co.com.screenplay.tasks.Login;
import co.com.screenplay.tasks.OpenTheBrowser;
import co.com.screenplay.tasks.SearchProduct;
import co.com.screenplay.tasks.SearchUsedProduct;
import co.com.screenplay.userinterfaces.MercadoLibrePage;
import static co.com.screenplay.utils.PropertiesFileUtil.readPropertiesFile;

import static org.hamcrest.Matchers.is;

import java.util.Properties;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ScreenplayStepDefinition {
	
	@Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Given("^I am in the main page of Mercado libre$")
	public void iAmInTheMainPageOfMercadoLibre() throws Exception {
		theActorCalled("User").attemptsTo(OpenTheBrowser.at());

	}
	
	@When("^I search for \"([^\"]*)\" in the web page$")
	public void iSearchForInTheWebPage(String data) throws Exception {
		theActorInTheSpotlight().attemptsTo(SearchProduct.at(MercadoLibrePage.SEARCH_BOX_AREA, MercadoLibrePage.SEARCH_BUTTON, data));
	}

	@Then("^I would see \"([^\"]*)\" like a title of the searh$")
	public void iWouldSeeLikeATitleOfTheSearh(String data) throws Exception {
		theActorInTheSpotlight().should(seeThat(CompareSearchPageTitle.like(data), is(true)));
	}
	
	
	@Given("^I am loggen in Mercado Libre$")
	public void iAmLoggenInMercadoLibre() throws Exception {
		
		Properties p = readPropertiesFile("login_information.properties");
		System.out.println(p.getProperty("password"));
		theActorCalled("User").attemptsTo(OpenTheBrowser.at(),
				Login.with(MercadoLibrePage.USERNAME_BOX, MercadoLibrePage.PASSWORD_BOX, MercadoLibrePage.CONTINUE_BUTTON,
						MercadoLibrePage.INGRESAR_BUTTON, MercadoLibrePage.INGRESAR_LOGIN_BUTTON, p.getProperty("user"), p.getProperty("password")));
	}


	@When("^I search for \"([^\"]*)\" used in the web page$")
	public void iSearchForUsedInTheWebPage(String data) throws Exception {
		theActorInTheSpotlight().attemptsTo(SearchUsedProduct.at(MercadoLibrePage.SEARCH_BOX_AREA, MercadoLibrePage.SEARCH_BUTTON, 
				MercadoLibrePage.TAG_USED, data));
	    
	}

	@Then("^I would see that the tag Usado is present$")
	public void iWouldSeeThatTheTagUsadoIsPresent() throws Exception {
		theActorInTheSpotlight().should(seeThat(ConfirmUsedTag.isPresentInPage(), is(true)));
		
	}


}
