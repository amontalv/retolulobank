package com.lulobank.stepdefinitions;

import com.lulobank.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hook {

    @Before
    public void inicializeActor(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("actor");
    }

    @Given("user automation service for create register")
    public void userAutomationServiceInUrl() {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(Constants.URL));
    }

}
