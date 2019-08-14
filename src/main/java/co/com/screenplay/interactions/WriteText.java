package co.com.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class WriteText implements Interaction {
	
	private final Target target;
	private final String text;
	
	public WriteText(Target target, String text) {	
		this.target = target;
		this.text = text;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		target.resolveFor(actor).sendKeys(text);
	}

	public static WriteText at(Target target, String text) {
		return instrumented(WriteText.class,target,text);
	}
}
