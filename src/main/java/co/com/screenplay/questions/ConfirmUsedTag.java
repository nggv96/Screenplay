package co.com.screenplay.questions;

import co.com.screenplay.userinterfaces.MercadoLibrePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmUsedTag implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		return MercadoLibrePage.TAG_USED_CLICKED.resolveFor(actor).isPresent();
	}

	public static ConfirmUsedTag isPresentInPage() {
		return new ConfirmUsedTag();
	}
}
