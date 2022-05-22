package com.lulobank.tasks;

import com.lulobank.utils.Constants;
import com.lulobank.utils.JsonEdit;
import com.lulobank.utils.UrlEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.List;

public class UpdateUser implements Task {

    private final List<String> values;

    public UpdateUser(List<String> values) {
        this.values = values;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(UrlEnum.URI_GET_USER.getValue() + values.get(0))
                .with(requestSpecification -> requestSpecification
                        .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                        .header("Accept", Constants.APPLICATION_JSON)
                        .body(JsonEdit.updateJson(values))));
    }

    public static UpdateUser withData(List<String> values) {
        return Tasks.instrumented(UpdateUser.class, values);
    }
}
