package co.com.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Open.url("https://www.mercadolibre.com.co"));
	}

	public static OpenTheBrowser at() {
		return instrumented(OpenTheBrowser.class);
	}
}
