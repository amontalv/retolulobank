package com.lulobank.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/com.lulobank.feature/createuserpost.feature",
        glue = "com.lulobank.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CreateUserPostRunner {
}
