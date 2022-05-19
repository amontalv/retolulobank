package com.lulobank.questions;

import com.lulobank.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserDeleteQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().jsonPath().get(Constants.MESSAGE).toString();
    }

    public static UserDeleteQuestion withUsername() {
        return new UserDeleteQuestion();
    }
}
