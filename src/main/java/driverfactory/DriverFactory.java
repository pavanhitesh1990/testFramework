package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

                case "sauce":
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 11");
                    browserOptions.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", "oauth-pavanfunny-674af");
                    sauceOptions.put("accessKey", "cbd60814-4656-4b63-9e18-1962a525ae79");
                    sauceOptions.put("build", "selenium-build-G0FPW");
                    sauceOptions.put("name", "SampleTest");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    URL url = null;
                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
                    threadDriver.set(driver);
                    threadDriver.get().manage().window().maximize();
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
