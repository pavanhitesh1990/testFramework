package ui.browser;

import driverfactory.DriverFactory;
import ui.Interactions;
import ui.Locate;

public class Type {

    Locate locate;

    Type(){
    }
    Type(Locate locate){
        this.locate=locate;
    }
    public static Type into(Locate locate){
        return new Type(locate);
    }

    public Interactions withValue(CharSequence... keysToSend){
        return new Interactions(this.locate,new Type(),keysToSend);
    }



}
