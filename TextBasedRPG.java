import java.util.Scanner;
import java.util.Random;

public class TextBasedRPG {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    //determines the amount of items you can carry
    public static int maxItems = 5;
    //this is your actual inventory
    public static String[] inventory = new String[maxItems];

    public static int tspeed = 20;
    public static boolean yes = false;

    // stats
    public static int speed = 1;
    public static int stealth = 1;
    public static int bullets = 1;
    public static int insanity = 1;

    //gambling
    public static int pennies = 0;
    public static int chip = 0;


    public static void main(String[] args)
    {
        fakemain();
    }

    public static void fakemain()
    {
        System.out.println("Welcome to our RPG game!");
        System.out.println("Press ENTER to begin...");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else{
            gamemode();
        }
    }

    public static void gamemode()
    {
        typewriter("which game mode do you want to play?");
        typewriter("Story mode / Casino only");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("story mode"))
        {
            typewriter(" ");
            intro();
        }
        else if (answer.equalsIgnoreCase("Casino only"))
        {
            typewriter(" ");
            pennies = 1000;
            casino();
        }
        else {
            typewriter("Incorrect value, please enter 'Story mode' or 'Casino only'");
            gamemode();
        }
    }

    public static void intro() {
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


        decisions();
    }

    public static void decisions() {
        typewriter("Do u enter the cave?");
        //decision
        System.out.println("(y / n)");
        String answer = scan.nextLine();
            //yes
            if (answer.equalsIgnoreCase("y")) {

                cave();
            }
            //no
            else if (answer.equalsIgnoreCase("n")) {
                typewriter("...u still broke but u survived... u go home... u pussy... good ending...");
            }

        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
            //incorrect text
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'.");
                decisions();
            }
    }

    public static void cave() {
        typewriter("U enter the cave");
        typewriter("Oh no!");
        typewriter("U encounter a monster");
        typewriter("What will you do?");
        typewriter("(run / hide / gun / stats)");
        String answer = scan.nextLine();
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

                    dead();
                }
                door();
            }
            //hide
            else if (answer.equals("hide")) {
                typewriter("U look around for a place to hide...");
                stealth++;
                typewriter("The monster is not looking. Stealth +1");
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
                    door();
                } else {
                    typewriter("U have no bullets. You can't use your gun.");
                    typewriter("The monster charges towards you, impaling you in the chest with its horn");
                    typewriter("The monster walks away, leaving you to bleed out on the ground");
                    typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
                    typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
                    typewriter("all you can do is pray while small insects and rodents feed on your flesh");
                    typewriter("... You died...     easter egg 1");

                    dead();
                }
            }
            //stats
            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                cave();
            }
            else if (answer.equalsIgnoreCase("debug"))
            {
                debug();

            }
            //wrong input
            else {
                typewriter("Invalid input. Please enter one of the answers.");
                cave();
            }
    }

    public static void door() {
        //choice 3
            typewriter("as you walk around the cave you come to a dead end");
            typewriter("there's a big rock wall blocking your path with a door in the middle");

            typewriter("what will you do?");
            typewriter("(check under carpet / open door / punch door / stats)");
            String answer = scan.nextLine();
            //check under carpet without key
            if (answer.equalsIgnoreCase("check under carpet") && inventory[1] == null) {
                typewriter("You found a key");
                inventory[1] = "1 - key";
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
                wall();
            }
            else if (answer.equalsIgnoreCase("punch door")) {
                typewriter("You try to punch the door, but the door punches you first.");
                typewriter("You died... idiot... door ending...");
                dead();
            }
            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                door();
            }
            else if (answer.equalsIgnoreCase("debug"))
            {
                debug();
            }
            else {
                typewriter("Invalid input. Please enter 'check under carpet', 'open door', 'punch door', or 'stats'.");
                door();
            }
    }

    public static void wall() {

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
                wall2();
            }

            else if (answer.equalsIgnoreCase("im out"))
            {
                typewriter("u are too much of a pussy to continue");
                int num = random.nextInt(0,11);

                if (num > 7)

                {
                    typewriter("u manage to leave the cave safely");
                    typewriter("the cowered good ending");
                }

                else

                {
                    typewriter("u get lost and starve to death");
                    typewriter("the cowered bad ending");
                }
            }

            else if (answer.equalsIgnoreCase("check around"))
            {
                typewriter("you found a bullet");
                typewriter("bullets +1");
                bullets++;
                wall2();
            }

            else if (answer.equals("stats")) {
                typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
                typewriter("Inventory: " + String.join(", ", inventory));
                wall();
            }
            else if (answer.equalsIgnoreCase("debug"))
            {
                debug();
            }
            else {
                typewriter("Invalid input. Please enter one of the answers.");
                wall();
            }

    }

    public static void wall2() {
        typewriter("what will you do?");
        typewriter("(shoot wall / im out / stats");

        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("shoot wall"))
        {
            typewriter("you shoot the wall");
            typewriter("it explodes");
            typewriter("bullets -1");
            bullets--;
            treasure();
        }
        else if (answer.equalsIgnoreCase("im out"))
        {
            typewriter("u are too much of a pussy to continue");
            int num = random.nextInt(0,11);

            if (num > 7)

            {
                typewriter("u manage to leave the cave safely");
                typewriter("... the cowered good ending...");

            }

            else

            {
                typewriter("u get lost and starve to death");
                typewriter("the cowered bad ending");
            }
        }

        else if (answer.equals("stats")) {
            typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
            typewriter("Inventory: " + String.join(", ", inventory));
            wall();
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else {
            typewriter("Invalid input. Please enter one of the answers.");
            wall();
        }
    }

    public static void treasure()
    {
        typewriter("as you enter the hole in the wall you created");
        typewriter("as soon as you step into the room it suddenly lightens up");
        typewriter("revealing a big golden chest in the middle of the room with a couple of coins around it");
        typewriter("what will you do");
        typewriter("open chest / take it / stats");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("open chest"))
        {
            typewriter("you open the chest");
            typewriter("it is filled with pennies");
            pennies();
        }

        else if (answer.equalsIgnoreCase("take it"))
        {
            typewriter("you attempt to steal the chest");
            typewriter("as soon as your finger tips touch the chest your whole hand turn into gold");
            typewriter("in less then a second you turn into a statue of solid gold");
            typewriter("you died...     chest ending");
            dead();
        }

        else if (answer.equals("stats")) {
            typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
            typewriter("Inventory: " + String.join(", ", inventory));
            wall();
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else {
            typewriter("Invalid input. Please enter one of the answers.");
            wall();
        }
    }

    public static void pennies()
    {
        typewriter("what will you do?");
        typewriter("(leave / eat a penny / stats)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("leave"))
        {
            typewriter("you grab all the 1000 pennies and put them in your pocket");
            typewriter("Inventory +1000 ( pennies)");
            inventory[3] = "1000 - pennies";
            pennies = 1000;
            typewriter("you leave the room");
            typewriter("leaving the chest empty");
        }

        else if (answer.equalsIgnoreCase("eat a penny"))
        {
            int num = random.nextInt(0,11);

            typewriter("you quickly grab a coin a put it in your mouth");
            typewriter("without thinking twice you swallow");

            if (num > 7)

            {
                typewriter("nothing happened");
                typewriter("you grab all the 1000 pennies and put them in your pocket");
                typewriter("Inventory +1000 (pennies)");
                inventory[3] = "1000 - pennies";
                pennies = 1000;
                typewriter("you leave the room");
                typewriter("leaving the chest empty");

                monster();
            }

            else

            {
                typewriter("suddenly you slipped and fell face first onto the ground");
                typewriter("as you stand up you notice a Sim coin on the ground");
                typewriter("you grab it");
                typewriter("inv +1 (Sim coin)");
                inventory[3] = "Sim coin";
                typewriter("you grab all the 1000 pennies and put them in your pocket");
                typewriter("Inventory +1000 (pennies)");
                inventory[4] = "1000 - pennies";
                pennies = 1000;
                typewriter("you leave the room");
                typewriter("leaving the chest empty");

                monster();
            }
        }

        else if (answer.equals("stats")) {
            typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
            typewriter("Inventory: " + String.join(", ", inventory));
            wall();
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else {
            typewriter("Invalid input. Please enter one of the answers.");
            wall();
        }
    }

    public static void monster()
    {
     typewriter(" ");
     typewriter("as you were walking you find a bullet on the ground");
     typewriter("");
     typewriter("suddenly you encounter a big monster");
     typewriter("what will you do");
     typewriter("(RPS / Run / Gun / Die / Stats)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("RPS"))
        {
            typewriter("you call the monster for a rock paper scissor battle");
            typewriter("surprisingly it agrees");
            typewriter("if you win you live");
            typewriter("if you loose you die");
            rps();
        }

        else if (answer.equalsIgnoreCase("run"))
        {
            typewriter("you start running");

            if (speed >= 1)
            {
                typewriter("you manage to run past the monster");
                gambling();
            }
            else {
                typewriter("The monster charges towards you, impaling you in the chest with its horn");
                typewriter("The monster walks away, leaving you to bleed out on the ground");
                typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
                typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
                typewriter("all you can do is pray while small insects and rodents feed on your flesh");
                typewriter("... You died...");
                dead();
            }
        }
        else if (answer.equalsIgnoreCase("gun"))
        {
            if (bullets > 0) {
                typewriter("U pull out your 38' caliber hand gun...");
                bullets--;
                insanity++;
                typewriter("The monster falls dead on the ground.");
                typewriter("u stare dow at the dead monster, who explodes into a pool of ketchup, covering you with sticky viscous ketchup");
                typewriter("in the back of your mind you can hear a faint whisper...    Bullets -1, insanity +1");
                typewriter("you manage to find a way out of the cave");
                dollar();
            }
        }
        else if (answer.equalsIgnoreCase("die"))
        {
            typewriter("The monster charges towards you, impaling you in the chest with its horn");
            typewriter("The monster walks away, leaving you to bleed out on the ground");
            typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
            typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
            typewriter("all you can do is pray while small insects and rodents feed on your flesh");
            typewriter("... You died...     please call 988 Help is available suicide is not the answer");
        }
        else if (answer.equals("stats")) {
            typewriter("Stats: Speed " + speed + "  Stealth " + stealth + "  Bullets " + bullets + "  insanity " + insanity);
            typewriter("Inventory: " + String.join(", ", inventory));
            wall();
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else {
            typewriter("Invalid input. Please enter one of the answers.");
            wall();
        }
    }

    public static void rps()
    {

        int round = 0;
        int pscore = 0;
        int mscore = 0;
        while (round < 3)
        {
            int mrolls = random.nextInt(1,4);

            typewriter(" ");
            typewriter("Round:" + round);
            typewriter("what will you do");
            typewriter("(Rock / Paper / Scissor / Score)");
            String answer = scan.nextLine();

            if (answer.equalsIgnoreCase("rock"))
            {
                typewriter("Player: Rock");
                typewriter(". . .");
                typewriter(" ");
                if (mrolls == 1)
                {
                    typewriter("Monster: Rock");
                    typewriter("You win!");
                    pscore++;
                    round++;
                }
                else if (mrolls == 2)
                {
                    typewriter("Monster: Paper");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
                else if (mrolls == 3)
                {
                    typewriter("Monster: Scissor");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
            }

            else if (answer.equalsIgnoreCase("paper"))
            {
                typewriter("Player: Rock");
                typewriter(". . .");
                typewriter(" ");
                if (mrolls == 1)
                {
                    typewriter("Monster: Rock");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
                else if (mrolls == 2)
                {
                    typewriter("Monster: Paper");
                    typewriter("You win!");
                    pscore++;
                    round++;
                }
                else if (mrolls == 3)
                {
                    typewriter("Monster: Scissor");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
            }

            else if (answer.equalsIgnoreCase("scissor"))
            {
                typewriter("Player: Rock");
                typewriter(". . .");
                typewriter(" ");
                if (mrolls == 1)
                {
                    typewriter("Monster: Rock");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
                else if (mrolls == 2)
                {
                    typewriter("Monster: Paper");
                    typewriter("You loose!");
                    mscore++;
                    round++;
                }
                else if (mrolls == 3)
                {
                    typewriter("Monster: Scissor");
                    typewriter("You win!");
                    pscore++;
                    round++;
                }
            }

            else if (answer.equalsIgnoreCase("score")) {
                typewriter("Score:");
                typewriter(" ");
                typewriter("Player - " + pscore);
                typewriter("Monster - " + mscore);
                typewriter(" ");
            }

            else {
                typewriter("Invalid choice! Please enter 'Rock' or 'Paper' or 'Scissor' or 'Score'");
                decisions();
            }
        }

        if (pscore > mscore)
        {
            typewriter("You manege to defeat the monster");
            typewriter("good job! now you can get out of here");
            gambling();
        } else if (pscore == mscore)
        {
            typewriter("its a Tie");
            typewriter("press enter to try again");
            scan.nextLine();
            rps();
        }
        else {
            typewriter("You lost");
            typewriter("the monster laughs at your face");
            typewriter("mocking you for even trying");
            typewriter("it grab its comically large butter knife and stabs you in the chest");
            typewriter("The monster walks away, still laughing as it leaves you to bleed out on the ground");
            typewriter("the pain is unimaginable, you start begging for your life hopping that somewhere someone, something would save you");
            typewriter("u can feel coldness rise from your core, your vision starts to darken, leaving you in the cold darkness of the cave");
            typewriter("all you can do is pray while small insects and rodents feed on your flesh");
            typewriter("... You died...");
            dead();

        }
    }

    public static void gambling()
    {
        typewriter("as you leave the cave your ego is in its peak");
        typewriter("you just won a 1000 pennies!");
        typewriter("what will you do?");
        typewriter("(go home / casino)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("go home"))
        {
            dollar();
        }
        else if (answer.equalsIgnoreCase("casino"))
        {
            casino();
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else {
            typewriter("Invalid choice! Please enter 'go home' or 'casino'");
            decisions();
        }
    }

    public static void casino()
    {
        if (chip < 0)
        {
            chip = 0;
        }
        typewriter(" ");
        typewriter("you enter the casino");
        typewriter("you have: " + pennies + " pennies left");
        typewriter("you have: " + chip + " chips left");
        typewriter("how many chips do you want to buy?");
        typewriter("10 / 100 / 500 / play / cash out");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("10"))
        {
            if (pennies >= 10) {
                typewriter("you bought 10 chips");
                chip = chip + 10;
                pennies = pennies - 10;
                typewriter("you have " + pennies + " pennies left");
                casino();
            }
            else {
                typewriter("you don't have enough pennies");
                casino();
            }
        }

        else if (answer.equalsIgnoreCase("100"))
        {
            if (pennies >= 100) {
                typewriter("you bought 100 chips");
                chip = chip + 100;
                pennies = pennies - 100;
                typewriter("you have " + pennies + " pennies left");
                typewriter(" ");
                casino();
            }
            else {
                typewriter("you don't have enough pennies");
                typewriter(" ");
                casino();
            }
        }

        else if (answer.equalsIgnoreCase("500"))
        {
            if (pennies >= 500) {
                typewriter("you bought 500 chips");
                chip = chip + 500;
                pennies = pennies - 500;
                typewriter("you have " + pennies + " pennies left" +
                        "");
                typewriter(" ");
                casino();
            }
            else {
                typewriter("you don't have enough pennies");
                typewriter(" ");
                casino();
            }
        }

        else if (answer.equalsIgnoreCase("play"))
        {
            typewriter("are you sure?");
            typewriter("y / n");
            String confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                games();
            }

            else if (confirm.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                casino();
            }
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'");
                decisions();
            }
        }

        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
        else if (answer.equalsIgnoreCase("cash out"))
        {
            typewriter("  ");
            typewriter("the minimum to cash out is 500 chips");
            typewriter("do you want to continue?");
            typewriter("(y / n)");
            String answer1 = scan.nextLine();

            if  (answer1.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                typewriter("pennies +" + chip);
                typewriter("chip -" + chip);

                pennies = pennies + chip;
                chip = 0;

                casino();
            }
            else if (answer1.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                casino();
            }
        }
        else {
            typewriter("Invalid choice! Please enter '10', '100', or '500'");
            typewriter(" ");
            casino();
        }
    }

    public static void games()
    {
        if (chip < 0)
        {
            chip = 0;
        }
        typewriter("you have:" + pennies + " pennies left");
        typewriter("you have:" + chip + " chips left");
        typewriter(" ");
        typewriter("what do you want to play?");
        typewriter("(blackjack (bj) / slots / coin flip (cf) / back)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("blackjack") || answer.equalsIgnoreCase("bj"))
        {
            typewriter("are you sure?");
            typewriter("y / n");
            String confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                bj();
            }

            else if (confirm.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                games();
            }
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'");
                decisions();
            }
        }
        else if (answer.equalsIgnoreCase("slots"))
        {
            typewriter("are you sure?");
            typewriter("y / n");
            String confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                slots();
            }

            else if (confirm.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                games();
            }
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'");
                decisions();
            }
        }
        else if (answer.equalsIgnoreCase("coin flip") || answer.equalsIgnoreCase("cf"))
        {
            typewriter("are you sure?");
            typewriter("y / n");
            String confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                cf();
            }

            else if (confirm.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                games();
            }
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'");
                decisions();
            }
        }
        else if (answer.equalsIgnoreCase("back"))
        {
            typewriter("are you sure?");
            typewriter("y / n");
            String confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("y"))
            {
                typewriter(" ");
                casino();
            }

            else if (confirm.equalsIgnoreCase("n"))
            {
                typewriter(" ");
                games();
            }
            else {
                typewriter("Invalid choice! Please enter 'y' or 'n'");
                decisions();
            }
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
            else {
            typewriter("Invalid choice! Please enter one of the answers");
            typewriter(" ");
            games();
        }
    }

    public static void bj()
    {

        int dcard1 = random.nextInt(1,12);
        int dcard2 = random.nextInt(1, 11);
        int dsc = dcard1;
        int pcard = random.nextInt(2, 22);
        int end = 0;

        typewriter("Blackjack");
        typewriter("---------");
        typewriter(" ");

        typewriter("do you want the tutorial?");
        typewriter("(y / n)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("y"))
        {
            typewriter(" ");
            typewriter("you'll be given 2 choices");
            typewriter("hit, stand");
            typewriter("if you select hit you'll draw a card");
            typewriter("if you select stand you'll end your turn");
            typewriter("if you get over 21 you loose");
            typewriter("if the dealer gets more then you, you loose");
            typewriter("if you get more then the dealer you win");
            typewriter("if you get the same as the dealer you tie");
            typewriter("the game will only end once you either win, tie, or loose");
            typewriter(" ");
            bj();
        }
        else if (answer.equalsIgnoreCase("n")) {
            typewriter(" ");
            typewriter("how much do you want to bet?");
            int bet = scan.nextInt();
            scan.nextLine();

            if (bet > chip) {
                typewriter("You don't have enough chips for that.");
                typewriter("Buy more and come back");
                casino();
            }

            while (end < 1) {
                if (chip < 0)
                {
                    chip = 0;
                }
                //stats
                typewriter(" ");
                typewriter("Player's card: " + pcard);
                typewriter("Dealer's card: " + dsc + " one card is hidden");
                typewriter("what will you do?");
                typewriter("(hit / stand)");
                String decision = scan.nextLine();

                //game
                if (decision.equalsIgnoreCase("hit"))
                {
                    int hit = random.nextInt(1, 12);
                    typewriter("Player's card: " + (pcard + hit));
                    pcard = pcard + hit;

                    if ((pcard + hit) >= 22) {
                        typewriter("Bust!");
                        chip = chip - bet;
                        typewriter("You lost: " + bet + " chips");
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm1 = scan.nextLine();

                        if (confirm1.equalsIgnoreCase("y"))
                        {
                            bj();
                            end++;
                        }
                        else if (confirm1.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            games();
                            end++;
                        }
                    }

                    else if ((pcard + hit) == 21) {
                        typewriter("Blackjack!");
                        typewriter(" ");
                        chip = bet * 2;
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm = scan.nextLine();
                        if (confirm.equalsIgnoreCase("y"))
                        {
                            end++;
                            bj();
                        }
                        else if (confirm.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            end++;
                            games();
                        }
                    }
                }
                else if (decision.equalsIgnoreCase("stand"))
                {
                    typewriter("Dealer reveals his cards");
                    dsc = dsc + dcard2;
                    typewriter("Dealer's hidden card: " + dcard2);
                    typewriter("Dealer's cards: " + dsc);

                    if (dsc < 17)
                    {
                        int hit = random.nextInt(1, 12);
                        typewriter(" ");
                        typewriter("The dealer is drawing a card");
                        dsc = dsc + hit;

                        typewriter("Dealer's cards: " + dsc);
                        typewriter("Your cards: " + pcard);

                        if (dsc > 22)
                        {
                            typewriter(" ");
                            typewriter("the dealer bust!");
                            typewriter("you win!");
                            chip = chip + bet;
                            typewriter("You won: " + bet + " chips");
                            typewriter(" ");
                            typewriter("do you wan to play again?");
                            typewriter("(y / n)");
                            String confirm = scan.nextLine();
                            if (confirm.equalsIgnoreCase("y"))
                            {
                                end++;
                                bj();
                            }
                            else if (confirm.equalsIgnoreCase("n"))
                            {
                                typewriter(" ");
                                end++;
                                games();
                            }

                        }
                        else if (dsc == 21)
                        {
                            typewriter(" ");
                            typewriter("the dealer got a blackjack!");

                            if (pcard == 21)
                            {
                                typewriter(" ");
                                typewriter("its a tie!");
                                typewriter("You lost/won: 0 chips");
                                typewriter(" ");
                                typewriter("do you wan to play again?");
                                typewriter("(y / n)");
                                String confirm = scan.nextLine();
                                if (confirm.equalsIgnoreCase("y"))
                                {
                                    end++;
                                    bj();
                                }
                                else if (confirm.equalsIgnoreCase("n"))
                                {
                                    typewriter(" ");
                                    end++;
                                    games();
                                }
                            }
                            else {
                                typewriter(" ");
                                typewriter("you lost!");
                                chip = chip - bet;
                                typewriter("You lost: " + bet + " chips");
                                typewriter(" ");
                                typewriter("do you wan to play again?");
                                typewriter("(y / n)");
                                String confirm = scan.nextLine();
                                if (confirm.equalsIgnoreCase("y"))
                                {
                                    end++;
                                    bj();
                                }
                                else if (confirm.equalsIgnoreCase("n"))
                                {
                                    typewriter(" ");
                                    games();
                                    end++;

                                }
                            }
                        }
                        else if (dsc < pcard)
                        {
                            typewriter(" ");
                            typewriter("you win!");
                            chip = chip + bet;
                            typewriter("You won: " + bet + " chips");
                            typewriter(" ");
                            typewriter("do you wan to play again?");
                            typewriter("(y / n)");
                            String confirm = scan.nextLine();
                            if (confirm.equalsIgnoreCase("y"))
                            {
                                end++;
                                bj();
                            }
                            else if (confirm.equalsIgnoreCase("n"))
                            {
                                typewriter(" ");
                                end++;
                                games();
                            }
                        }
                        else if (dsc > pcard)
                        {
                            typewriter(" ");
                            typewriter("you lost!");
                            chip = chip - bet;
                            typewriter("You lost: " + bet + " chips");typewriter(" ");
                            typewriter("do you want to play again?");
                            typewriter("(y / n)");
                            String confirm = scan.nextLine();
                            if (confirm.equalsIgnoreCase("y"))
                            {
                                end++;
                                bj();
                            }
                            else if (confirm.equalsIgnoreCase("n"))
                            {
                                typewriter(" ");
                                end++;
                                games();
                            }
                        }
                        else
                        {
                            typewriter(" ");
                            typewriter("its a tie!");
                            typewriter("You lost/won: 0 chips");typewriter(" ");
                            typewriter("do you wan to play again?");
                            typewriter("(y / n)");
                            String confirm = scan.nextLine();
                            if (confirm.equalsIgnoreCase("y"))
                            {
                                end++;
                                bj();
                            }
                            else if (confirm.equalsIgnoreCase("n"))
                            {
                                typewriter(" ");
                                end++;
                                games();
                            }
                        }
                    }
                }
                else {
                    typewriter("please enter 'hit' or 'stand'");
                    end++;
                }


            }
        }

        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
    }

    public static void slots()
    {
        if (chip < 0)
        {
            chip = 0;
        }
        int num1 = random.nextInt(1, 8);
        int num2 = random.nextInt(1, 8);
        int num3 = random.nextInt(1, 8);

        typewriter("Slot Machines");
        typewriter("---------");
        typewriter(" ");

        typewriter("do you want the tutorial?");
        typewriter("(y / n)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("y"))
        {
            typewriter(" ");
            typewriter("the slot machine will roll 3 random numbers");
            typewriter("your prize varies depending on which number the machine lands on");
            typewriter("3 unmatched numbers = 1x");
            typewriter("2 matched numbers = 2x");
            typewriter("3 matched numbers = 3x");
            typewriter("777 = 5x");
            typewriter(" ");
            typewriter("the machine can also take money away from you");
            typewriter("so you need to be careful");
            typewriter("1 6 = -1x");
            typewriter("2 6's = -2x");
            typewriter("3 6's = -5x");
            typewriter(" ");
            slots();
        }
        else if (answer.equalsIgnoreCase("n")) {


            typewriter(" ");
            typewriter("how much do you want to bet?");
            int bet = scan.nextInt();
            scan.nextLine();

            if (bet > chip) {
                typewriter("You don't have enough chips for that.");
                typewriter("Buy more and come back");
                casino();
            }

            boolean end = false;
            while (end == false)
            {
                //spin effect
                System.out.println("_ _ _ _ _");
                System.out.println("|" + " * * * " + "|   o");
                System.out.println("|" + " * * * " + "|  /");
                System.out.println("|" + " * * * " + "| /");
                System.out.println("- - - - -");
                typewriter("press enter to start");
                String start = scan.nextLine();

                System.out.println(" ");
                System.out.println(" ");
                System.out.println("_ _ _ _ _");
                System.out.println("|" + " * * * " + "|");
                System.out.println("|" + " " + num1 + " " + num2 + " " + num3 + " " + "|");
                System.out.println("|" + " * * * " + "| ---o");
                System.out.println("- - - - -");


                if (num1 == 6 || num2 == 6 || num3 == 6)
                {
                    System.out.println(" ");
                    typewriter("you got a six!");
                    typewriter("you win nothing!");
                    bet = bet * -1;
                    chip = bet + chip;
                    typewriter(" ");
                    typewriter("do you want to play again?");
                    typewriter("(y / n)");
                    String confirm1 = scan.nextLine();

                    if (confirm1.equalsIgnoreCase("y"))
                    {
                        slots();
                        end = true;
                    }
                    else if (confirm1.equalsIgnoreCase("n"))
                    {
                        typewriter(" ");
                        games();
                        end = true;
                    }
                }
                else {
                    System.out.println(" ");
                    typewriter("you got 3 unmatched numbers!");
                    typewriter("you got: " + bet * 1 + "chips");
                    chip = bet - chip;
                    typewriter(" ");
                    typewriter("do you wan to play again?");
                    typewriter("(y / n)");
                    String confirm1 = scan.nextLine();

                    if (confirm1.equalsIgnoreCase("y"))
                    {
                        slots();
                        end = true;
                    }
                    else if (confirm1.equalsIgnoreCase("n"))
                    {
                        typewriter(" ");
                        games();
                        end = true;
                    }
                }

                if (num1 == num2 || num1 == num3 || num2 == num3)
                {
                    System.out.println(" ");
                    typewriter("you got a match!");

                    if (num1 == 6 && num2 == 6 || num1 == 6 && num3 == 6 || num2 == 6 && num3 == 6)
                    {
                        typewriter("you got two 6's!");

                        typewriter("you lost: " + bet * -2 + " chips");
                        bet = bet * -2;
                        chip = bet + chip;
                    }
                    else {
                        typewriter("you dint get a single 6!");
                        typewriter("you won: " + bet * 2 + " chips");
                        bet = bet * 2;
                        chip = bet + chip;
                    }
                }

                else if (num1 == num2 && num1 == num3)
                {
                    System.out.println(" ");
                    if (num1 == 6 && num2 == 6 && num3 == 6)
                    {
                        typewriter("you got three 6's!");

                        typewriter("you lost: " + bet * -5 + " chips");
                        bet = bet * -5;
                        chip = bet + chip;
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm1 = scan.nextLine();

                        if (confirm1.equalsIgnoreCase("y"))
                        {
                            slots();
                            end = true;
                        }
                        else if (confirm1.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            games();
                            end = true;
                        }
                    }
                    else if (num1 == 7 && num2 == 7 && num3 == 7)
                    {
                        typewriter("you got three 7's!");

                        typewriter("you won: " + bet * 5 + " chips");
                        bet = bet * 5;
                        chip = bet + chip;
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm1 = scan.nextLine();

                        if (confirm1.equalsIgnoreCase("y"))
                        {
                            slots();
                            end = true;
                        }
                        else if (confirm1.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            games();
                            end = true;
                        }
                    }
                    else {
                        typewriter("you dint get a single 6!");
                        typewriter("you won: " + bet * 3 + " chips");
                        bet = bet * 3;
                        chip = bet + chip;
                        typewriter(" ");
                        typewriter("do you want to play again?");
                        typewriter("(y / n)");
                        String confirm1 = scan.nextLine();

                        if (confirm1.equalsIgnoreCase("y"))
                        {
                            slots();
                            end = true;
                        }
                        else if (confirm1.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            games();
                            end = true;
                        }
                    }
                }
            }
        }

        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }
    }

    public static void cf()
    {
        if (chip < 0)
        {
            chip = 0;
        }
        typewriter("Coin Flip");
        typewriter("---------");
        typewriter(" ");

        typewriter("do you want the tutorial?");
        typewriter("(y / n)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y"))
        {
            typewriter(" ");
            typewriter("you choose heads or tails");
            typewriter("you flip a coin");
            typewriter("if you guess it right you win 2x");
            typewriter("else you win nothing");
            typewriter(" ");
            slots();
        }
        else if (answer.equalsIgnoreCase("n")) {
            typewriter(" ");
            typewriter("how much do you want to bet?");
            int bet = scan.nextInt();
            scan.nextLine();

            if (bet > chip) {
                typewriter("You don't have enough chips for that.");
                typewriter("Buy more and come back");
                casino();
            }

            int coin = random.nextInt(1, 3);
            //1 = heads 2 = tails


            boolean end = false;

            while (end == false) {
                typewriter(" ");
                typewriter("heads or tails?");
                String choice = scan.nextLine();


                if (choice.equalsIgnoreCase("heads")) {
                    typewriter(" ");

                    if (coin == 1) {
                        typewriter("the coin landed on heads!");
                        typewriter(" .  .  . ");
                        typewriter(" ");
                        typewriter("you won!");
                        chip = chip + bet;
                        typewriter("You won: " + bet + " chips");
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm = scan.nextLine();

                        if (confirm.equalsIgnoreCase("y"))
                        {
                            end = true;
                            cf();
                        }
                        else if (confirm.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            end = true;
                            games();
                        }


                    }

                    else if (coin == 2)
                    {

                        typewriter("the coin landed on tails!");
                        typewriter(" .  .  . ");
                        typewriter(" ");
                        typewriter("you loose!");
                        chip = chip - bet;
                        typewriter("You lost: " + bet + " chips");
                        typewriter(" ");
                        typewriter("do you wan to play again?");
                        typewriter("(y / n)");
                        String confirm = scan.nextLine();

                        if (confirm.equalsIgnoreCase("y"))
                        {
                            end = true;
                            cf();
                        }
                        else if (confirm.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            end = true;
                            games();
                        }
                    }

                }

                else if (choice.equalsIgnoreCase("tails")) {
                    typewriter(" ");


                    if (coin == 1) {
                        typewriter("the coin landed on heads!");
                        typewriter(" .  .  . ");
                        typewriter(" ");

                        typewriter("you loose!");
                        chip = chip - bet;
                        typewriter("You lost: " + bet + " chips");
                        typewriter(" ");
                        typewriter("do you want to play again?");
                        typewriter("(y / n)");
                        String confirm = scan.nextLine();

                        if (confirm.equalsIgnoreCase("y"))
                        {
                            end = true;
                            cf();
                        }
                        else if (confirm.equalsIgnoreCase("n"))
                        {
                            typewriter(" ");
                            end = true;
                            games();

                    }

                    else if (coin == 2)
                    {
                            typewriter("the coin landed on tails!");
                            typewriter(" .  .  . ");
                            typewriter(" ");

                            typewriter("you won!");
                            chip = chip + bet;
                            typewriter("You won: " + bet + " chips");
                            typewriter(" ");
                            typewriter("do you wan to play again?");
                            typewriter("(y / n)");

                            if (confirm.equalsIgnoreCase("y"))
                            {
                                end = true;
                                cf();
                            }
                            else if (confirm.equalsIgnoreCase("n"))
                            {
                                typewriter(" ");
                                end = true;
                                games();
                            }
                        }
                    }

                }

                else {
                        typewriter("please enter 'heads' or 'tails'");
                        end = true;
                }
            }
        }
        else if (answer.equalsIgnoreCase("debug"))
        {
            debug();
        }

    }

    public static void dollar()
    {
        if (insanity >= 2)
        {
            typewriter("");
            typewriter("your head starts getting fuzzy and you feel sick");
            typewriter("the only thing you can hear is a voice inside your head shouting at you");
            typewriter("telling you to buy a dollar");
            typewriter(" ");
            typewriter("after a few days you cant handle it anymore");
            typewriter("the voice has only gotten louder and louder");
            typewriter("your head feels like its going to explode");
            typewriter("you finally gives in and buy the dollar for a 1000 pennies");
            typewriter(". . .");
            typewriter("...     Insanity end");

        }
        else {
            typewriter("you go home with a 1000 pennies");
            typewriter("unfortunately for you the IRS is knocking at your door");
            typewriter("they demand you hand them the 1000 pennies at it is classified as government property");
            typewriter("you have no choice but comply");
            typewriter("...     you live in the US dummy. Any valuable treasure you find is considered government property");
            typewriter("...     1000 pennies end");
        }
    }

    public static void dead()
    {
        typewriter("what is your name?");
        String Name = scan.nextLine();
        typewriter(Name + " you suck!");
    }

    public static void debug() {
        String psswrd = "Thor103023";
        if (yes == false) {
            typewriter(" ");
            typewriter("whats the code?");
            String code = scan.nextLine();
            while (!code.equals(psswrd)) {
                typewriter("wrong");
                code = scan.nextLine();
            }
            if (code.equals(psswrd))
            {
                yes = true;
            }
        }

        typewriter(" Debug");
        typewriter("-------");
            typewriter(" ");
            typewriter("($ / map / chip / stat / txt sped / end)");
            String answer = scan.nextLine();

            if (answer.equalsIgnoreCase("$")) {
                typewriter("how much");
                pennies = scan.nextInt();
                typewriter("pennies: " + pennies);
                scan.nextLine();

                debug();
            } else if (answer.equalsIgnoreCase("map")) {
                typewriter("where");
                typewriter("(main / intro / decisions / cave / door / wall / wall2 / treasure / pennies / monster / rps / gambling / casino / games / bj / slots / cf / dollar / dead)");
                String map = scan.nextLine();
                if (map.equalsIgnoreCase("main")) {
                    fakemain();
                }
                if (map.equalsIgnoreCase("intro")) {
                    intro();
                } else if (map.equalsIgnoreCase("decisions")) {
                    decisions();
                } else if (map.equalsIgnoreCase("cave")) {
                    cave();
                } else if (map.equalsIgnoreCase("wall")) {
                    wall();
                } else if (map.equalsIgnoreCase("wall2")) {
                    wall2();
                } else if (map.equalsIgnoreCase("treasure")) {
                    treasure();
                } else if (map.equalsIgnoreCase("pennies")) {
                    pennies();
                } else if (map.equalsIgnoreCase("monster")) {
                    monster();
                } else if (map.equalsIgnoreCase("rps")) {
                    rps();
                } else if (map.equalsIgnoreCase("gambling")) {
                    gambling();
                } else if (map.equalsIgnoreCase("casino")) {
                    casino();
                } else if (map.equalsIgnoreCase("games")) {
                    games();
                } else if (map.equalsIgnoreCase("bj")) {
                    bj();
                } else if (map.equalsIgnoreCase("slots")) {
                    slots();
                } else if (map.equalsIgnoreCase("cf")) {
                    cf();
                } else if (map.equalsIgnoreCase("dollar")) {
                    dollar();
                } else if (map.equalsIgnoreCase("dead")) {
                    dead();
                }
            } else if (answer.equalsIgnoreCase("chip")) {
                typewriter("how much");
                chip = scan.nextInt();
                typewriter("chip: " + chip);
                scan.nextLine();

                debug();
            } else if (answer.equalsIgnoreCase("stat")) {
                typewriter("(speed / stealth / bullets / insanity)");
                String stats = scan.nextLine();
                if (stats.equalsIgnoreCase("speed")) {
                    typewriter("how much");
                    speed = scan.nextInt();
                    typewriter("speed: " + speed);
                    scan.nextLine();

                    debug();
                }
                if (stats.equalsIgnoreCase("stealth")) {
                    typewriter("how much");
                    stealth = scan.nextInt();
                    typewriter("stealth: " + stealth);
                    scan.nextLine();

                    debug();
                }
                if (stats.equalsIgnoreCase("bullets")) {
                    typewriter("how much");
                    bullets = scan.nextInt();
                    typewriter("bullets: " + bullets);
                    scan.nextLine();

                    debug();
                }
                if (stats.equalsIgnoreCase("insanity")) {
                    typewriter("how much");
                    insanity = scan.nextInt();
                    typewriter("insanity: " + insanity);
                    scan.nextLine();

                    debug();
                }

            } else if (answer.equalsIgnoreCase("txt sped")) {
                typewriter("how much");
                tspeed = scan.nextInt();
                scan.nextLine();

                debug();
            } else if (answer.equalsIgnoreCase("end")) {
                return;
            }
    }

    public static void typewriter(String text) {
        int i;
        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(tspeed);//0.5s pause between characters
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }







    //file ends on next line
}
