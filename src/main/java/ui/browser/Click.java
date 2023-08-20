package ui.browser;

import ui.Interactions;
import ui.Locate;

public class Click {


    Click(){

    }

    public static Interactions on(Locate locate){
        return new Interactions(locate , new Click());
    }

}
