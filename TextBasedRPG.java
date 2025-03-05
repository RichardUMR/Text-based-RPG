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
                cave();
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
    }

    public static void cave() {
        String answer = scan.nextLine();
        //choice 2
        if (choices == 2) {
            //run
            if (answer.equals("run")) {
                int num = random.nextInt(0, 1);

                if (num > 0)

                {
                    typewriter("U start running...");
                    typewriter("...");
                    speed++;
                    typewriter("The dumb monster cant keep up with u.");
                    typewriter("U run past monster. Speed +1");
                }

                else

                {
                    typewriter("U start running...");
                    typewriter("The monster charges towards you, impaling you in the chest with its horn");
                    typewriter("The monster walks away, leaving you to bleed out on the ground");
                    typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
                    typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
                    typewriter("all you can do is pray while small insects and rodents feed on your flesh");
                    typewriter("... You died...");

                    return;
                }



                choices = 3;
                door();
            }
            //hide
            else if (answer.equals("hide")) {
                typewriter("U look around for a place to hide...");
                stealth++;
                typewriter("The monster is not looking. Stealth +1");

                choices = 3;
                door();
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
                    door();
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
                cave();
            }
            //wrong input
            else {
                typewriter("Invalid input. Please enter one of the answers.");
                cave();
            }
        }
    }

    public static void door() {
        //choice 3
        if (choices == 3) {
            typewriter("as you walk around the cave you come to a dead end");
            typewriter("there's a big rock wall blocking your path with a door in the middle");

            typewriter("what will you do?");
            typewriter("(check under carpet / open door / punch door / stats)");
            String answer = scan.nextLine();
            //check under carpet without key
            if (answer.equalsIgnoreCase("check under carpet") && inventory[1] == null) {
                typewriter("You found a key");
                inventory[1] = "key";
                typewriter("Inventory +1 (Key)");

                door();
            }
            //check under carpet with key
            else if (answer.equalsIgnoreCase("check under carpet") && inventory[1] != null) {
                typewriter("There is nothing under the carpet.");
                door();
            }
            //open door without key
            else if (answer.equalsIgnoreCase("open door") && inventory[1] == null) {
                typewriter("You try to open the door, but it is locked. You need a key.");
                door();
            }
            //open door with key
            else if (answer.equalsIgnoreCase("open door") && inventory[1] != null) {
                typewriter("You use your key and unlock the door.");
                inventory[1] = null;
                typewriter("The door opens.");

                choices = 4;
                wall();
            }
            else if (answer.equalsIgnoreCase("punch door")) {
                typewriter("You try to punch the door, but the door punches you first.");
                typewriter("You died... idiot... door ending...");
                return;
            }
            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                door();
            }
            else {
                typewriter("Invalid input. Please enter 'check under carpet', 'open door', 'punch door', or 'stats'.");
                door();
            }
        }
    }

    public static void wall() {
        if (choices == 4)
        {
            typewriter("only to be met with a iron wall");
            typewriter("what will you do?");
            typewriter("(punch it / im out / check around / stats)");

            String answer = scan.nextLine();

            if (answer.equalsIgnoreCase("punch it"))
            {
                typewriter("u punch the metal door");
                typewriter("ur hands shatter into a billion pieces");
                typewriter("surprisingly it worked");
                typewriter("you must be crazy!");
                typewriter("insanity +1");
                insanity++;

                choices = 5;
            }

            else if (answer.equalsIgnoreCase("im out"))
            {
                typewriter("u are too much of a pussy to continue");
                int num = random.nextInt(0,11);

                if (num > 7)

                {
                    typewriter("u manage to leave the cave safely");
                }

                else

                {
                    typewriter("as u leave the cave a bunch of monsters appear out of nowhere");
                    typewriter("there is no where to hide or run");
                    typewriter("u have no bullets left");
                    typewriter("the cowered ending");
                    return;
                }

                choices = 5;
            }

            else if (answer.equalsIgnoreCase("check around"))
            {
                typewriter("you found a bullet");
                typewriter("bullets +1");
                bullets++;
                typewriter("you shoot the wall");
                typewriter("it explodes");
                typewriter("bullets -1");
                bullets--;
                 choices = 5;
            }

            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                wall();
            }
            else {
                typewriter("Invalid input. Please enter one of the answers.");
                wall();
            }
        }
    }


    public static void typewriter(String text) {
        int i;
        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(15);//0.5s pause between characters
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("");
    }







    //file ends on next line
}
