import java.util.Scanner;
import java.util.Random;

public class TextBasedRPG {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    //determines the amount of items you can carry
    public static int maxItems = 5;
    //this is your actual inventory
    public static String[] inventory = new String[maxItems];

    public static int choices = 1;
    // stats
    public static int speed = 1;
    public static int stealth = 1;
    public static int bullets = 1;
    public static int racism = 1;


    public static void main(String[] args)
    {
        System.out.println("Welcome to our RPG game!");
        System.out.println("Press ENTER to begin...");
        scan.nextLine();
        intro();
    }

    public static void intro()
    {
        //who is mc
        typewriter("U Broke boy");
        //story
        typewriter("Legend says there's 1000 pennies in this random cave named:");
        typewriter("'PLEASE DON'T ENTER! YOU WILL DIE! DON'T ENTER! THERE IS 0% SURVIVAL! FOR THE LOVE OF GOD! GO HOME!'...");
        typewriter("... ... ... sounds like harmless fun! :D");


        //Location
        typewriter("U are in front of the cave");
        //Quest
        typewriter("Do u enter the cave?");
        //decision
        System.out.println("(y / n)");

        decisions();
    }

    public static void decisions()
    {
        String answer = scan.nextLine();
        //choice 1
        while (choices <= 1)
        {
            //yes
            if (answer.equalsIgnoreCase("y")) {
                choices++;
                typewriter("U enter the cave");
                typewriter("Oh no!");
                typewriter("U encounter a monster");
                typewriter("What will you do?");
                typewriter("(run / hide / american dream/ stats)");
                break;
            }
            //no
            if (answer.equalsIgnoreCase("n")) {
                choices++;
                typewriter("...u still broke but u survived...  u go home...      pussy...    good ending...");
                break;
            }
        }

        //choice 2
                //run
        while (choices == 2) {
            if (answer.equalsIgnoreCase("run")) {
                typewriter("U start running");
                typewriter("The dumb monster cant keep up with u");
                typewriter("U run past monster");
                typewriter("speed +1");
                speed++;
            }
            //hide
            if (answer.equalsIgnoreCase("hide")) {
                typewriter("U look around for a place to hide");
                typewriter("U hide behind a big rock");
                typewriter("The monster is not looking");
                typewriter("U manage to sneak around the monster");
                typewriter("stealth +1");
                stealth++;
            }
            //gun
            if (answer.equalsIgnoreCase("american dream || gun")) {
                typewriter("U pull out your 38' caliber hand gun");
                typewriter("U pull out & check the mag");
                typewriter("U have" + bullets + " bullets left");
                typewriter("U push the mag back in");
                typewriter("U reload ur gun and take aim");
                typewriter("U pull the trigger");
                typewriter("the monster falls dead on the ground");
                typewriter("u can feel your american dream grow");
                typewriter("racism +1...        bullets -1");
                racism++;
                bullets--;
            }

            //stats
            if (answer.equalsIgnoreCase("american dream || gun")) {
                typewriter("speed" + speed + "  ...     stealth" + stealth + "  ...     bullets" + bullets + "  ...     racism" + racism);
            }
        }
    }


    public static void typewriter(String text) {
        int i;
        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(75);//0.5s pause between characters
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("");
    }







    //file ends on next line
}