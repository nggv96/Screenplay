package co.com.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Clicks implements Interaction {
	
	Target targetClick;
	
	public Clicks(Target targetClick) {
		this.targetClick = targetClick;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
	
	actor.attemptsTo(Click.on(targetClick));
	}
	
	public static Clicks at(Target targetClick) {
		return instrumented(Clicks.class, targetClick);
	}

}
