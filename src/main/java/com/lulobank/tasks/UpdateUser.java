package com.lulobank.tasks;

import com.lulobank.utils.Constants;
import com.lulobank.utils.UrlEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUser implements Task {

    private final String username;
    private String phone;

    public UpdateUser(String username) {
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "\"id\":25,\n" +
                "\"username\":\"prueba\",\n" +
                "\"firstName\":\"albeiro\",\n" +
                "\"lastName\":\"Aguirre\",\n" +
                "\"email\":\"pruba@hola.com\",\n" +
                "\"password\":\"hola mundo\",\n" +
                "\"phone\":\"" +phone+"\",\n" +
                "\"userStatus\":2\n" +
                "}";

        actor.attemptsTo(Put.to(UrlEnum.URI_GET_USER.getValue() + username)
                .with(requestSpecification -> requestSpecification
                        .header(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON)
                        .header("Accept",Constants.APPLICATION_JSON)
                        .body(body)));
    }

    public static UpdateUser withUsername(String username){
        return Tasks.instrumented(UpdateUser.class,username);
    }

    public UpdateUser withPhone(String phone){
        this.phone = phone;
        return this;
    }
}
