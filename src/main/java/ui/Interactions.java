package ui;

import dev.failsafe.internal.util.Assert;
import driverfactory.DriverFactory;
import ensure.Ensure;
import io.cucumber.java.sl.In;
import lombok.*;
import org.openqa.selenium.WebElement;
import ui.browser.Click;
import ui.browser.Type;
import ui.browser.Wait;


public class Interactions implements Execute{



    private Locate locate;
    private String action;
    private String value;

    private CharSequence[] keysToSend;

    private Object object;

    private String compare;
    private Object expected;




    public Interactions(Locate locate, Object object){
        this.locate = locate;
        this.object = object;
    }

    public Interactions(Locate locate,Object object,CharSequence... keysToSend){
        this.locate = locate;
        this.object = object;
        this.keysToSend = keysToSend;
    }

    public Interactions(String value,Object object){
        this.value=value;
        this.object = object;
    }

    public Interactions(Object object, String compare,Locate locate,Object expected){
        this.object =object;
        this.compare = compare;
        this.locate = locate;
        this.expected = expected;

    }


    @Override
    public void execute() {

        if(this.object instanceof Click){
            Wait.waitForElementPresent(this.locate.element()).click();
        } else if (this.object instanceof Type) {
            Wait.waitForElementPresent(this.locate.element()).sendKeys(this.keysToSend);
        }else if (this.object instanceof Browser){
            DriverFactory.getCurrentDriver().get(this.value);
        }else if (this.object instanceof Ensure){
            ensure();
        }


    }

    public void ensure(){
        if(compare.equalsIgnoreCase("isDisplayed")){
            WebElement webElement = Wait.waitForElementPresent(this.locate.element());
            if(!webElement.isDisplayed()){
                System.out.println(String.format("Element [%s] with identification [%s] not displayed",this.locate.name(),this.locate.element().toString()));
            }
        }
        if(compare.equalsIgnoreCase("isPresent")){
            WebElement webElement = Wait.waitForElementPresent(this.locate.element());
            if(webElement ==null){
                System.out.println(String.format("Element [%s] with identification [%s] not displayed",this.locate.name(),this.locate.element().toString()));
            }
        }
        if(compare.equalsIgnoreCase("textEqualTo")){
            WebElement webElement = Wait.waitForElementPresent(this.locate.element());
            String actualText = webElement.getText();
            if(!actualText.equals(this.expected.toString())){
                System.out.println(String.format("Actual [%s] and Expected [%s] are not equal",actualText,this.expected));
            }
        }

        if(compare.equalsIgnoreCase("textContains")){
            WebElement webElement = Wait.waitForElementPresent(this.locate.element());
            String actualText = webElement.getText();
            if(!actualText.contains(this.expected.toString())){
                System.out.println(String.format("Actual [%s] and Expected [%s] are not equal",actualText,this.expected));
            }
        }
    }
}
