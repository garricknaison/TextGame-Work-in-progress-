import java.util.*;

public class TextGame {
    static Scanner gn = new Scanner(System.in);
    static int health = 100;
    static String store[] = new String[5];
    static int k = 0;
    static int f = 0;

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("An error has occurred.");
        }
    }

    public static void win() {
        System.out.println("Hooray!");
        pause(2000);
        System.out.println("You successfully made it out of the forest.");
        pause(1000);
        System.out.println(
                "Don't worry. The police is already after the group of criminals who attacked you and stole your car.");
        pause(500);
        System.out.println("THE END");
        pause(4000);
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.println("Hope you enjoyed this simple game.");
        System.out.println("I greatly appreciate any feedback you have.");
        pause(30000);
        System.exit(0);
    }

    public static void death() {
        System.out.println("You passed away... better luck next time.");
        pause(30000);
        System.exit(0);
    }

    public static int search(String g, String store[], int k) {
        for (int j = 0; j < k; j++) {
            if (store[j] != null && store[j].equals(g)) {
                return 1;
            }
        }
        return 0;
    }

    public static int store(String st, String store[], int k) {
        store[k] = st;

        System.out.println("You now have the " + st + " .");
        System.out.println("The item(s) in your inventory are: ");
        for (int i = 0; i <= k; i++) {
            System.out.print(store[i] + "| ");
        }
        System.out.println();
        ++k;
        return k;
    }

    public static int attack(int health, int max, int min) {
        int r = (int) (Math.random() * (max - min + 1)) + min;
        health = health - r;
        pause(1000);
        System.out.println("You lost " + r + " HP.\nNow your health is " + health + " HP.");
        if (health < 20) {
            System.out.println("Your health is too low.");
            death();
        }
        return health;
    }

    public static void northriver() {
        pause(1000);
        System.out.println("As you walk towards the river, you see a bear blocking your path.");
        pause(1000);
        System.out.println("You have two options: fight or walk past the bear.");
        System.out.println("What do you do?(fight/walk)");
        String ff = gn.next();
        if (ff.equalsIgnoreCase("fight")) {
            health = attack(health, 20, 11);// format for attack
            System.out.println("You defeated the bear.");
            System.out.println("You notice a key next to the dead bear. Do you wish to take it?(yes/no)");
            String e = gn.next();
            if (e.equalsIgnoreCase("yes")) {
                k = store("key", store, k);
            } // format for store
            System.out.println("Your journey continues.");
        } else
            System.out.println("Your journey continues.");

    }

    public static void southforest() {
        System.out.println("You walk for sometime towards the deeper parts of the forest.");
        pause(1000);
        System.out.println("You suddenly find an abandoned car.");
        System.out.println("You can search it or continue walking. What do you do?(search/walk)");
        String l = gn.next();
        if (l.equalsIgnoreCase("search")) {
            System.out.println("You search inside the car and is surprised to find a family of mice inside.");
            pause(1000);
            System.out.println("The mice attacked you out of their surprise.");
            health = attack(health, 10, 5);
            System.out.println("But, it was worth it. You found an old Nokia phone.");
            pause(500);
            System.out.println("Do you wish to try using it or continue walking?(use/walk)");
            String df = gn.next();
            if (df.equalsIgnoreCase("use")) {
                pause(1000);
                System.out.println(
                        "What a relief, it turns on.\nBut to call for help, you need range.\nTry going to higher grounds.");
                pause(500);
                System.out.println("Do you wish to add this into your inventory?(yes/no)");
                String hh = gn.next();
                if (hh.equalsIgnoreCase("yes"))
                    k = store("phone", store, k);
            }
        }
        pause(1000);
        System.out.println("You approach a divide in the path.");
        pause(500);
        System.out.println(
                "You can either go left, which seems to lead to a small hill or you could go right, which is totally dark.");
        System.out.println("Where do you go?(left/right)");
        String gh = gn.next();
        if (gh.equalsIgnoreCase("right")) {
            System.out.println("You walk towards your right.");
            pause(1000);
            System.out.println("Suddenly you are attacked by a wild animal.");
            System.out.println("It seems too strong, maybe a wolf or a tiger.");
            System.out.println("Do you try to protect yourself?(yes/no)");
            String yn = gn.next();
            if (yn.equalsIgnoreCase("yes")) {
                pause(2000);
                if (search("pistol", store, k) == 1) {
                    pause(2000);
                    System.out.println("You can use your pistol.");
                    System.out.println("Do you wish to use it?(yes/no)");
                    String s3 = gn.next();
                    pause(3000);
                    System.out.println(
                            "Curse your luck.... there were no bullets inside them. Maybe you had to collect it from somewwere else... but now....");
                }
                System.out.println("You try your best using a large stick to defend yourself.");
                pause(500);
                System.out.println("But it only makes it easier for the large predator to jump on you.");
                attack(health, 79, 99);
            }
        }

        else {
            System.out.println("You walk towards your left.");
            pause(2000);
            System.out.println("Just as you had predicted, you reached a small hill.");
            f = search("phone", store, k);
            if (f == 1) {
                pause(3000);
                System.out.println("You can now access the phone and try for range.");
                pause(1500);
                System.out.println("You get really lucky as somehow the phone is able to make a call.");
                System.out.println(
                        "You call the emergency services.\nThey will will be here by half an hour, till then you must wait.");
                pause(2000);
                System.out.println("They emergency services succesfully reached you...");
                win();
            } else {
                System.out.println("You feel into a deep well.");
                attack(health, 79, 99);
            }

        }

    }

    public static void inCabin(int cc) {
        if (cc == 0) {
            pause(2000);
            System.out.println("You find the key, hidden under the mat in front of the door.");
            pause(1000);
            System.out.println("You unlock and walk inside the cabin.");
            pause(1000);
            System.out.println(
                    "You can see some nuts and rasins sitting on the table. They look fine so you decide to eat them.");
            pause(1000);
            System.out.println("They tasted stale but it has slightly raised your energy.");
            pause(2000);
            System.out.println(
                    "To the left of the table you see a dairy sitting open with the following note: \"Car broke down in south portion of forest. Going to to town to get a mechanic.\"");
            pause(2000);
            System.out.println(
                    "It seems that the owner's car had broken down in the southern portion of the forest...perhaps if you go there you might be able to fix it and get out of here.");
            pause(2000);
            System.out.println(
                    "Inside the drawer of the table, you find a pistol. Seems pretty old but it could be of some use, considering the possibility of wild animals attacking you.");
            pause(1000);
            System.out.println("Do you wish to add it to the inventory?(yes/no)");
            String e1 = gn.next();
            if (e1.equalsIgnoreCase("yes"))
                k = store("pistol", store, k);
            pause(1000);
        } else {
            pause(2000);
            System.out.println("You reside in the cabin for now.");
        }
    }

    public static void eastcabin() {
        int count = 0;
        System.out.println("You choose  to walk to the east where you can see a faint light glowing.");
        pause(1000);
        System.out.println("You reach at what appears to be a cabin. It looks deserted but the front door was locked.");
        pause(500);
        System.out.println(
                "You could search for the key or you can continue walking to the east, which is not of much use.");
        System.out.println("What do you want to do?(search/walk)");
        String e1 = gn.next();
        if (e1.equalsIgnoreCase("search")) {
            inCabin(count);
            count = 1;
            System.out.println(
                    "You continue looking but find nothing else of any importance. So you decide to leave the cabin.");
            pause(500);
            System.out.println(
                    "You are now outside, it seems half an hour or so had passed since you entered the cabin.");
            pause(500);
            System.out.println(
                    "You can either ontinue walking towards the east or head south to look for the broke down car.");
            pause(500);
            System.out.println("Where do you want to go?(east/south)");
            e1 = gn.next();
            if (e1.equalsIgnoreCase("south"))
                southforest();

        }
        System.out.println("You decide to walk further east.");
        pause(1000);
        System.out.println("It is getting darker and darker.");
        pause(1000);
        System.out
                .println("You start feeling the presence of some other creature around you. It seems to be stalking.");
        pause(1000);
        System.out.println("Turning around would be good.");
        System.out.println(
                "Maybe you could go back to the cabin you had seen earlier and escape from any immediate and basic danger.");
        pause(2000);
        System.out.println("What do you wish to do?(cabin/continue)");
        e1 = gn.next();
        if (e1.equalsIgnoreCase("continue")) {
            pause(1000);
            System.out.println("You decide to continue walking despite the immense danger.");
            pause(2000);
            System.out.println(
                    "500 metres or so, you were met by what seems to traces of blood...possibly animal blood.");
            pause(2000);
            System.out.println("Going forward now scares you and you decide to go back.");
        }
        inCabin(count);
        pause(3000);
        System.out.println("After some time you decide to go south to look for the abondoned car.");
        pause(2000);
        System.out.println("You walk to the place you had been in the beginning and continue south.");
        pause(2000);
        southforest();
    }

    public static void westpath() {
        pause(2000);
        System.out.println("You decide to go west towards the winding path.");
        pause(2000);
        System.out.println("You see a small fire in ");/// not
                                                       /// finished **************************************************
    }

    public static void main(String args[]) {
        Scanner gn = new Scanner(System.in);
        System.out.println("**The Trail**");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        pause(2000);
        System.out.println(
                "In this game, you will be faced with multiple options and you can make your own decisions. But remember, your decisions have effects in the future.");
        System.out
                .println("You can make your decisions by typing in the options that are shown along with the prompt.");
        System.out.println("You also have an inventory which can store maximum 5 objects.");
        System.out.println(
                "You have 100 health and if it falls  below 20, you will pass out and will have to start again.");
        pause(4000);
        System.out.println("Here we go...");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        pause(2000);
        System.out.println(
                "You are at the center of a clearing. You were dumped here by a group of criminals who had hijacked your car. You must find your way out before...");
        System.out.println(
                "To the north, you hear the rush of a river. To the east, a faint light glows. \nTo the south, the forest seems to grow darker. To the west, a dark winding path .");
        pause(2000);
        System.out.println("Which way do you want to go?(north/south/east/west)");
        String g = gn.next();
        if (g.equalsIgnoreCase("north")) {
            System.out.println("You walk north, towards the river.");
            northriver();
        } else if (g.equalsIgnoreCase("south")) {
            System.out.println("You walk south, where the forest seems to grow darker.");
            southforest();
        } else if (g.equalsIgnoreCase("east")) {
            System.out.println("You walk east, where you see a faint light glowing.");
            eastcabin();
        } else if (g.equalsIgnoreCase("west")) {
            System.out.println("You walk west, where you see a winding path.");
        } else
            System.out.println("Wrong choice.");
    }
}
