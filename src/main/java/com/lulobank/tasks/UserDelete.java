package com.lulobank.tasks;

import com.lulobank.utils.Constants;
import com.lulobank.utils.UrlEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class UserDelete implements Task {

    private final String username;

    public UserDelete(String username) {
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(UrlEnum.URI_GET_USER.getValue() + username)
                .with(requestSpecification -> requestSpecification
                        .header("Accept", Constants.APPLICATION_JSON)));
    }

    public static UserDelete withUsername(String username){
        return Tasks.instrumented(UserDelete.class,username);
    }
}
