package com.lulobank.stepdefinitions;

import com.lulobank.exceptions.ServicePathException;
import com.lulobank.questions.UserDeleteQuestion;
import com.lulobank.tasks.UserDelete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.CoreMatchers;

public class UserDeleteStepDefinition {

    @When("user delete information for")
    public void userDeleteInformationFor(String username) {
        OnStage.theActorInTheSpotlight().attemptsTo(UserDelete.withUsername(username));
    }
    @Then("valid in response delete of username")
    public void validInResponseDeleteOfUsername(String username) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(UserDeleteQuestion.withUsername(), CoreMatchers.equalTo(username)).orComplainWith(ServicePathException.class));
    }

}
