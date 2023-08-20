package pageobjects;

import ensure.Ensure;
import org.openqa.selenium.Keys;
import ui.Actions;
import ui.Browser;
import ui.Locate;
import ui.browser.Click;
import ui.browser.Type;

public class HomePage {


    public Locate searchInput(){
        return Locate.the("Search Text Box").withXpath("//input[@class='new-todo']");
    }
    public Locate todoRows(){
        return Locate.the("List of ToDo").withXpath("//li[@class='todo']");
    }

    public Locate removedItem(String name){
        return Locate.the("Remove Item").withXpath(String.format("//label[text()='%s']/parent::div/button",name));
    }

    public Locate markItemCompleted(String name){
        return Locate.the("Mark Item Completed").withXpath(String.format("//label[text()='%s']/parent::div/input[@type='checkbox']",name));
    }

    public Locate totalToDoCount(){
        return Locate.the("Total To Do Count").withXpath("//footer//following::span[@class='todo-count']/strong");
    }


    public Locate btnActive(){
        return Locate.the("BTN ACTIVE").withXpath("//ul[@class='filters']//a[text()='Active']");
    }

    public Locate btnCompleted(){
        return Locate.the("BTN ACTIVE").withXpath("//ul[@class='filters']//a[text()='Completed']");
    }

    public Locate btnClearCompleted(){
        return Locate.the("BTN Clear Completed").withXpath("//button[@class='clear-completed']");
    }


    public Locate getLabel(String labelName){
        return Locate.the("Get Item Added or Active").withXpath(String.format("//label[text()='%s']",labelName));
    }


    public Actions navigateApplication(String url){
        return new Actions("Navigate to Application", Browser.open().to(url));
    }

    public Actions addItemAndCompleteIt(String itemName){
        return Actions.list("Add Item and Complete it", Type.into(searchInput()).withValue(itemName),
                Type.into(searchInput()).withValue(Keys.ENTER),
                Click.on(markItemCompleted(itemName)));
    }

    public Actions verifyItemAddedActive(String itemName){
        return Actions.list("Verifying item completed", Click.on(btnCompleted()),
                Ensure.that(getLabel(itemName)).isPresent());
    }

}
