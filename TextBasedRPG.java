import java.util.Scanner;
import java.util.Random;

public class TextBasedRPG {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static String yes = "y";
    public static String no = "n";
    //determines the amount of items you can carry
    public static int maxItems = 5;
    //this is your actual inventory
    public static String[] inventory = new String[maxItems];




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
        typewriter("Legend says there's 1000 pennies in the cave named 'PLEASE DON'T ENTER! YOU WILL DIE! DON'T ENTER! THERE IS 0% SURVIVAL! FOR THE LOVE OF GOD! GO HOME!'");
        //Location
        typewriter("U are in front of the cave ' '");
        //Quest
        typewriter("Do u enter the cave?");
        //decision
        System.out.println("(y / n)");
        decisions();
    }

    public static void decisions()
    {
        String choice = scan.nextLine();
        //yes
        if (choice.equalsIgnoreCase("y"))
        {
            System.out.println("U enter the cave");
            System.out.println("Oh no!");
            System.out.println("U encounter a monster");
            System.out.println("What will you do?");
            System.out.println("(fight / hide / gun)");

        }
        //no
        if (choice.equalsIgnoreCase("n"))
        {
            typewriter("test");
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