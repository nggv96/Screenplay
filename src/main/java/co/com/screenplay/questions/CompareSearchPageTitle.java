package co.com.screenplay.questions;

import co.com.screenplay.userinterfaces.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CompareSearchPageTitle implements Question<Boolean> {
	
	String data;
	
	public CompareSearchPageTitle(String data) {
		this.data = data;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		
		return Text.of(MercadoLibrePage.SEARCH_PAGE_TITLE).viewedBy(actor).asString().equalsIgnoreCase(data);
	}
	
	public static CompareSearchPageTitle like(String data) {
		return new CompareSearchPageTitle(data);
	}

}
