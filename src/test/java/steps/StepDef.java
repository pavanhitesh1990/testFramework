package steps;

import annotate.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import ui.User;

public class StepDef {


    @Page
    private static HomePage homePage;
    @Given("User in on the home page")
    public void user_in_on_the_home_page() {
        User.perform(homePage.navigateApplication("https://todomvc.com/examples/vue/"));
    }

    @When("User add a item {string} as to do")
    public void user_add_a_item_as_to_do(String string) {
        User.perform(homePage.addItemAndCompleteIt(string));
    }
    @Then("user marks the item {string} as completed")
    public void user_marks_the_item_as_completed(String string) {
        User.perform(homePage.verifyItemAddedActive(string));
    }
}
