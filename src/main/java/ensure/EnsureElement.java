package ensure;

import ui.Interactions;
import ui.Locate;

public class EnsureElement {

   Locate locate;

   public EnsureElement(Locate locate){
       this.locate = locate;
   }


   public Interactions isDisplayed(){
       return new Interactions(new Ensure(),"isDisplayed",this.locate,null);
   }

    public Interactions isPresent(){
        return new Interactions(new Ensure(),"isPresent",this.locate,null);
    }
    public Interactions textEqualTo(String expectedText){
        return new Interactions(new Ensure(),"textEqualTo",this.locate,expectedText);
    }

    public Interactions textContains(String expectedText){
        return new Interactions(new Ensure(),"textContains",this.locate,expectedText);
    }

}
