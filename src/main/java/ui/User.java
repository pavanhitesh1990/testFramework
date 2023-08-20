package ui;

public class User {



    public static void performs(Interactions...interactions){
        for(Interactions interaction:interactions){
            perform(interaction);
        }
    }

    public static void perform(Interactions interaction){
            interaction.execute();
    }

    public static void performs(Actions...actions){
        for(Actions action:actions){
            perform(action);
        }
    }

    public static void perform(Actions actions){
        performs(actions.getInteractions());
    }




}
