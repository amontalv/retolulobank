package com.lulobank.tasks;

import com.lulobank.utils.Constants;
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
        String body = "{\n" +
                "\"id\":" + data.get(0) + ",\n" +
                "\"username\":\"" + data.get(1) +"\",\n" +
                "\"firstName\":\"" + data.get(2) +"\",\n" +
                "\"lastName\":\"" + data.get(3) +"\",\n" +
                "\"email\":\"" + data.get(4)+"\",\n" +
                "\"password\":\"" +data.get(5)+"\",\n" +
                "\"phone\":\"" +data.get(6)+"\",\n" +
                "\"userStatus\":" +data.get(7)+ "\n" +
                "}";

        actor.attemptsTo(Post.to(UrlEnum.URI_USER_CREATE.getValue())
                .with(requestSpecification -> requestSpecification
                        .header(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON)
                        .header("Accept",Constants.APPLICATION_JSON)
                        .body(body)));
    }

    public static CreateUserPost withData(List<String>data){
        return Tasks.instrumented(CreateUserPost.class,data);
    }
}
