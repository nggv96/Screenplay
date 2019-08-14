package co.com.screenplay.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class MercadoLibrePage {
	
	public static final Target SEARCH_BOX_AREA = Target.the("Search box in the main page").locatedBy("//input[@name='as_word']");
	public static final Target SEARCH_BUTTON = Target.the("Search button in the main page").locatedBy("//button[@class = 'nav-search-btn']");
	public static final Target SEARCH_PAGE_TITLE = Target.the("Title of the search in the search page").locatedBy("//*[@id=\"inner-main\"]/aside/div[1]/h1");
	public static final Target INGRESAR_BUTTON = Target.the("Button to begin the login").locatedBy("//a[contains(text(),'Ingresa')][@tabindex='8']");
	public static final Target USERNAME_BOX = Target.the("Username area in login page").located(By.id("user_id"));
	public static final Target CONTINUE_BUTTON = Target.the("Button to continue to enter the password").locatedBy("//input[@value='Continuar']");
	public static final Target PASSWORD_BOX = Target.the("Password area in login page").located(By.id("password"));
	public static final Target INGRESAR_LOGIN_BUTTON = Target.the("Button to finish the login").locatedBy("//button[@value='complete']");
	public static final Target TAG_USED = Target.the("The tag Usado to apply the filter").locatedBy("//section//dl//dd//a//span[contains(text(),'Usado')]");
	public static final Target TAG_USED_CLICKED = Target.the("The tag Usado when the filter es applied").locatedBy("//section//dl//a//dd//h2//div[contains(text(),'Usado')]");
	
}
