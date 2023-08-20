package ui.browser;

import driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    public static WebElement waitForElementPresent(By by){
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getCurrentDriver(), Duration.ofSeconds(30));
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        moveElement(webElement);
        return webElement;
    }

    private static void moveElement(WebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getCurrentDriver();
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",ele);
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
    }

    public static List<WebElement> waitForAllElementToPresent(By by){
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getCurrentDriver(), Duration.ofSeconds(30));
        List<WebElement> webElements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        moveElement(webElements.get(0));
        return webElements;
    }

}
