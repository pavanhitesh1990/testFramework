package test;


import annotate.DependencyInjector;
import driverfactory.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import ui.Execute;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {
                "report.adapter.ExtentCucumberAdapter:"},
        glue = {"steps"},dryRun = false, tags = "@smoke")
public class TestRunner {



    @BeforeClass
    public static void before(){
        try {
            System.setProperty("browser","sauce");
            Date date = new Date();
            SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-sss");
            String stringDate= DateFor.format(date);
            System.setProperty("testName",String.format("TestRun-%s-%s",stringDate,Thread.currentThread().getId()));
            DependencyInjector.injectDependencies("steps");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterClass
//    public static void tearDown(){
//        DriverFactory.getCurrentDriver().quit();
//    }

}
