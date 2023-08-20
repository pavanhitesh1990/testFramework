package ensure;

import ui.Locate;

public class Ensure {


   public static  EnsureElement that(Locate locate){
        return new EnsureElement(locate);
    }



}
