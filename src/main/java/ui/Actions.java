package ui;

import io.cucumber.java.en_old.Ac;

import java.util.Arrays;

public class Actions {

    private Interactions [] interactions;
    private String title;

    public Actions(String title, Interactions [] interactions){
        this.title = title;
        this.interactions =interactions;
    }

    public Actions(String title, Interactions interactions){
        this.title = title;
        Interactions [] interactions1 = {interactions};
        this.interactions = interactions1;
    }

    public Interactions [] getInteractions(){
        return this.interactions;
    }

    public String getTitle(){
        return  this.title;
    }

    public static Actions list(String title, Interactions...interactions){
        return new Actions(title,interactions);
    }

}
