package com.lulobank.tasks;

import com.lulobank.utils.Constants;
import com.lulobank.utils.JsonEdit;
import com.lulobank.utils.UrlEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

public class CreateUserPost implements Task {

    private final List<String> data;

    public CreateUserPost(List<String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(UrlEnum.URI_USER_CREATE.getValue())
                .with(requestSpecification -> requestSpecification
                        .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                        .header("Accept", Constants.APPLICATION_JSON)
                        .body(JsonEdit.createJson(data))));
    }

    public static CreateUserPost withData(List<String> data) {
        return Tasks.instrumented(CreateUserPost.class, data);
    }
}
