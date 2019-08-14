package co.com.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.screenplay.interactions.Clicks;
import co.com.screenplay.interactions.WriteText;

public class Login implements Task {
	
	Target userBox, pssBox, continueButton, ingresarButton, finalizarButton;
	String userName,pss;
	
	public Login(Target userBox, Target pssBox, Target continueButton, Target ingresarButton, Target finalizarButton, String userName, String pss) {
		this.userBox = userBox;
		this.pssBox = pssBox;
		this.userName = userName;
		this.pss = pss;
		this.continueButton = continueButton;
		this.ingresarButton = ingresarButton;
		this.finalizarButton = finalizarButton;
		
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Clicks.at(ingresarButton),
				WriteText.at(userBox, userName),
				Clicks.at(continueButton),
				WriteText.at(pssBox, pss),
				Clicks.at(finalizarButton));
		
	}

	public static Login with(Target userBox, Target pssBox, Target continueButton, Target ingresarButton, Target finalizarButton, String userName, String pss) {
		return instrumented(Login.class,userBox, pssBox, continueButton, ingresarButton, finalizarButton, userName, pss);
	}
}
