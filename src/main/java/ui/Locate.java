package ui;

import org.openqa.selenium.By;

public class Locate {

    private String elementName;
    private By by;

    public By element(){
        return  this.by;
    }

    public String name(){
        return this.elementName;
    }

    public Locate(String elementName,By by){
        this.elementName=elementName;
        this.by = by;
    }

    public Locate(String elementName){
        this.elementName = elementName;
    }

    public static Locate the(String elementName){
        return new Locate(elementName);
    }

    public Locate withXpath(String xpath){
        return new Locate(this.elementName,By.xpath(xpath));
    }

    public Locate withId(String id){
        return new Locate(this.elementName,By.id(id));
    }

    public Locate withName(String name){
        return new Locate(this.elementName,By.name(name));
    }

    public Locate withTagName(String tagName){
        return new Locate(this.elementName,By.tagName(tagName));
    }

    public Locate withCss(String css){
        return new Locate(this.elementName,By.cssSelector(css));
    }

    public Locate withPartialTagName(String partialTagName){
        return new Locate(this.elementName,By.partialLinkText(partialTagName));
    }
}
