package co.com.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.screenplay.interactions.Clicks;
import co.com.screenplay.interactions.WriteText;

public class SearchUsedProduct implements Task{
	
	String text;
	Target targetWrite, targetClick, usedTag;
	
	public SearchUsedProduct(Target targetWrite, Target targetClick, Target usedTag, String text) {
		
		this.text = text;
		this.targetWrite = targetWrite;
		this.targetClick = targetClick;
		this.usedTag = usedTag;
	
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WriteText.at(targetWrite, text), 
				Clicks.at(targetClick),
				Clicks.at(usedTag));
		
	}
	
	public static SearchUsedProduct at(Target targetWrite, Target targetClick, Target usedTag, String text) {
		return instrumented(SearchUsedProduct.class, targetWrite, targetClick, usedTag, text);
	}

}
