package com.lulobank.stepdefinitions;

import com.lulobank.exceptions.ServicePathException;
import com.lulobank.questions.CreateUserPostQuestion;
import com.lulobank.tasks.CreateUserPost;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.CoreMatchers;

import java.util.List;

public class CreateUserStepDefinition {

    @When("user want create user to service")
    public void userWantCreateUserToService(DataTable dataTable) {
        List<String> data = dataTable.values();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUserPost.withData(data));
    }
    @Then("user valid the status code {int}")
    public void userValidTheStatusCode(Integer statusCode) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(
               validatableResponse -> validatableResponse.statusCode(statusCode)
        ).orComplainWith(ServicePathException.class));
    }
    @Then("valid in response code {int}")
    public void validInResponseCode(Integer code) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CreateUserPostQuestion.code(), CoreMatchers.equalTo(code)).orComplainWith(ServicePathException.class));
    }
}
