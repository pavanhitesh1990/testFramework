package steps;

import annotate.DependencyInjector;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.Browser;


public class Hooks {

    @After
    public void before(){

        DriverFactory.getCurrentDriver().close();

    }

}
