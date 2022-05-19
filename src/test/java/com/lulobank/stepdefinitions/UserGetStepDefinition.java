package com.lulobank.stepdefinitions;

import com.lulobank.exceptions.ServicePathException;
import com.lulobank.questions.UserGetQuestion;
import com.lulobank.tasks.UserGet;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class UserGetStepDefinition {

    @When("user consult information for")
    public void userConsultInformationFor(String username) {
        OnStage.theActorInTheSpotlight().attemptsTo(UserGet.withUsername(username));
    }

    @Then("valid in response information in firstname and lastname")
    public void validInResponseInformationInFirstnameAndLastname(DataTable dataTable) {
        List<String> data = dataTable.values();
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(UserGetQuestion.withInformation(data)).orComplainWith(ServicePathException.class));

    }
}
