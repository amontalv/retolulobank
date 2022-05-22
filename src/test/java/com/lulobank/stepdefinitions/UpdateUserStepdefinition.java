package com.lulobank.stepdefinitions;

import com.lulobank.tasks.UpdateUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class UpdateUserStepdefinition {

    @When("user want update information of user")
    public void userWantUpdateInformationOfUser(DataTable dataTable) {
        List<String> values = dataTable.values();
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.withData(values));
    }

}
