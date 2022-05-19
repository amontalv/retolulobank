package com.lulobank.questions;

import com.lulobank.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreateUserPostQuestion implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().jsonPath().get(Constants.CODE);
    }

    public static CreateUserPostQuestion code() {
        return new CreateUserPostQuestion();
    }
}
