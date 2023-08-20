package ui;

import driverfactory.DriverFactory;

public class Browser {

    Browser(){

    }

    public  static Browser open(){
        DriverFactory.getDriver();
        return new Browser();
    }

    public Interactions to(String url){
        return new Interactions(url,new Browser());
    }

    public void navigateTo(String url){
        DriverFactory.getCurrentDriver().navigate().to(url);
    }

}
