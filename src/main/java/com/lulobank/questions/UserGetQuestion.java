package com.lulobank.questions;

import com.lulobank.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class UserGetQuestion implements Question<Boolean> {

    private final List<String> data;

    public UserGetQuestion(List<String> data) {
        this.data = data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String firstName = SerenityRest.lastResponse().getBody().jsonPath().get(Constants.FIRSTNAME).toString();
        String lastName = SerenityRest.lastResponse().getBody().jsonPath().get(Constants.LASTNAME).toString();

        return firstName.equalsIgnoreCase(data.get(0)) && lastName.equalsIgnoreCase(data.get(1));
    }

    public static UserGetQuestion withInformation(List<String> data) {
       return new UserGetQuestion(data);
    }

}
