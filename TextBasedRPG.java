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
    public static int insanity = 1;


    public static void main(String[] args)
    {
        System.out.println("Welcome to our RPG game!");
        System.out.println("Press ENTER to begin...");
        scan.nextLine();
        intro();
    }

    public static void intro()
    {
        inventory[0] = "38' Caliber Handgun";

        //who is mc
        typewriter("U r Broke boy");
        //story
        typewriter("Legend says there's 1000 pennies in this random cave named:");
        typewriter("'PLEASE DON'T ENTER! YOU WILL DIE! DON'T ENTER! THERE IS 0% SURVIVAL! FOR THE LOVE OF GOD! GO HOME!'...");
        typewriter("... ... ... sounds like harmless fun! :D");


        //Location
        typewriter("U r in front of the cave");
        //Quest
        typewriter("Do u enter the cave?");
        //decision
        System.out.println("(y / n)");

        decisions();
    }

    public static void decisions() {
        String answer = scan.nextLine();
        //choice 1
        if (choices == 1) {
            //yes
            if (answer.equals("y")) {
                typewriter("U enter the cave");
                typewriter("Oh no!");
                typewriter("U encounter a monster");
                typewriter("What will you do?");
                typewriter("(run / hide /gun / stats)");

                choices = 2;
                scan.nextLine();
            }
            //no
            else if (answer.equals("n")) {
                typewriter("...u still broke but u survived... u go home... u pussy... good ending...");
                return;
            }
            //incorrect text
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'.");
                decisions();
            }
        }

        //choice 2
        if (choices == 2) {
            //run
            if (answer.equals("run")) {
                typewriter("U start running...");
                speed++;
                typewriter("The dumb monster cant keep up with u.");
                typewriter("U run past monster. Speed +1");

                choices = 3;
                scan.nextLine();
            }
            //hide
            else if (answer.equals("hide")) {
                typewriter("U look around for a place to hide...");
                stealth++;
                typewriter("The monster is not looking. Stealth +1");

                choices = 3;
                typewriter("press enter to continue");
                scan.nextLine();
            }
            //gun
            else if (answer.equals("gun")) {
                if (bullets > 0) {
                    typewriter("U pull out your 38' caliber hand gun...");
                    bullets--;
                    insanity++;
                    typewriter("The monster falls dead on the ground.");
                    typewriter("u stare dow at the dead monster, who explodes into a pool of ketchup, covering you with sticky viscous ketchup");
                    typewriter("in the back of your mind you can hear a faint whisper...    Bullets -1, insanity +1");

                    choices = 3;
                    typewriter("press enter to continue");
                    scan.nextLine();
                } else {
                    typewriter("U have no bullets. You can't use your gun.");
                    typewriter("The monster charges towards you, impaling you in the chest with its horn");
                    typewriter("The monster walks away, leaving you to bleed out on the ground");
                    typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
                    typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
                    typewriter("all you can do is pray while small insects and rodents feed on your flesh");
                    typewriter("... You died...     easter egg 1");

                    return;
                }
            }
            //stats
         else if (answer.equals("stats")) {
            typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
            typewriter("Inventory: " + String.join(", ", inventory));
            decisions();
        }
        //wrong input
            else {
                typewriter("Invalid input. Please enter 'y' or 'n'.");
                decisions();
            }
        }

        //choice 3
        if (choices == 3) {
            //story
            typewriter("as you walk around the cave you come to a dead end");
            typewriter("there's a big rock wall blocking your path with a door in the middle");
            //choices
            typewriter("what will you do?");
            typewriter("(check under carpet / open door / punch door / stats");

            //check under carpet with key
            if (answer.equalsIgnoreCase("check under carpet") && inventory[1].equals("null"))
            {
                typewriter("you found a key");
                typewriter("inv +1");
                inventory[1] = "key";
                decisions();
            }
            //check under carpet without key
            else if (answer.equalsIgnoreCase("check under carpet") && inventory[1].equals("key"))
            {
                typewriter("there is nothing under the carpet");
                decisions();
            }
            //open door without key
            else if (answer.equalsIgnoreCase("open door") && inventory[1].equals("null"))
            {
                typewriter("you try to open the door");
                typewriter("the door is locked");
                typewriter("you need a key");
                decisions();
            }
            //open door with key
            else if (answer.equalsIgnoreCase("open door") && inventory[1].equals("key"))
            {
                typewriter("you use your key and unlock the door");
                typewriter("inv -1");
                inventory[1] = "null";
                typewriter("you try to open the door");
                typewriter("the door is open");

                choices = 4;
            }
            //punch door
            else if (answer.equalsIgnoreCase("punch door"))
            {
                typewriter("you try to punch the door");
                typewriter("but the door punches you first");
                typewriter("you died...     idiot...      door ending...");
                return;
            }
            //stats
            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                decisions();
            }
            //wrong input
            else {
                typewriter("Invalid input. Please enter 'y' or 'n'.");
                decisions();
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