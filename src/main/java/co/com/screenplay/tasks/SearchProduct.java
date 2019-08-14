package co.com.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.screenplay.interactions.Clicks;
import co.com.screenplay.interactions.WriteText;

public class SearchProduct implements Task {
	
	String text;
	Target targetWrite, targetClick;
	
	public SearchProduct(Target targetWrite, Target targetClick, String text) {
		this.text = text;
		this.targetWrite = targetWrite;
		this.targetClick = targetClick;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WriteText.at(targetWrite, text), 
				Clicks.at(targetClick));
		
	}
	
	public static SearchProduct at(Target targetWrite, Target targetClick, String text) {
		
		return instrumented(SearchProduct.class,targetWrite,targetClick,text);
	}

}
