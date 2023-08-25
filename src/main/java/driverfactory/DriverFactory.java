package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new InheritableThreadLocal<>();


    private static void invokeWebDriverInstance(){
        if(threadDriver.get()==null){
            String browser = System.getProperty("browser");
            browser = browser == null ? "chrome":browser;
            switch (browser) {
                case "chrome":
                    if(System.getProperty("webdriver.chrome.driver") ==null) {
                        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
                    }
                   threadDriver.set(new ChromeDriver(setChromeOptions()));
                   threadDriver.get().manage().window().maximize();
                   break;
            }
        }
    }

    public static WebDriver getDriver(){
        if(threadDriver.get()==null){
            invokeWebDriverInstance();
        }

        return threadDriver.get();
    }

    public static WebDriver getCurrentDriver(){

        return threadDriver.get();
    }

    public static void quit(){
        threadDriver.get().quit();
        threadDriver.set(null);
    }

    private static ChromeOptions setChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        if(System.getProperty("headless")!=null)
        options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
