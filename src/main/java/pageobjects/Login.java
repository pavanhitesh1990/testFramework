package pageobjects;

import ui.Actions;
import ui.Browser;
import ui.Locate;
import ui.browser.Click;
import ui.browser.Type;

public class Login {

    public Locate findEmailAddress(){
        return Locate.the("EmailAddress").withId("email");
    }

    public Locate findPassword(){
        return Locate.the("Password").withName("password");
    }

    public Locate findLoginBtn(){
        return Locate.the("LoginButton").withXpath("//button[@type='submit']");
    }

    public Actions navigate(String url){
        return new Actions("User Navigate",Browser.open().to("https://app.simplelogin.io/auth/login"));
    }
    public Actions login(String userName,String password){
        return Actions.list("Login to Page",
                Type.into(findEmailAddress()).withValue(userName),
                Type.into(findPassword()).withValue(password),
                Click.on(findLoginBtn()));
    }

}
