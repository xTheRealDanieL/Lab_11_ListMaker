import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String menu;
        boolean done = false;

        do {
            menu = display(in, list);
            switch(menu.toLowerCase())
            {
                case "q":
                    if(quit()) {
                        done = true;
                    }
                    break;
                case "a":
                    add(in, list);
                    break;
                case "d":
                    if (list.size() ==0)
                    {
                        System.out.println("There is nothing in your list");
                        break;
                    }
                    delete(in, list);
                    break;
                case "p":
                    print(list);
                    break;
            }
        }while(!done);

    }
    private static boolean quit()
    {
        Scanner in = new Scanner(System.in);
        return SafeInput.getYNConfirm(in, "Are you sure");
    }
    public static void add(Scanner in, ArrayList list)
    {
        String item = SafeInput.getNonZeroLength(in,"Enter your item");
        list.add(item);
    }

    public static void delete(Scanner in, ArrayList list)
    {
        int high = list.size();
        int num = SafeInput.getRangedInt(in, "Enter the order number of item that you want to delete", 1, high);
        list.remove(num-1);
    }

    public static void print(ArrayList list)
    {
        for (int i=0; i<list.size();i++)
        {
            System.out.println((i+1) + " " + list.get(i));
        }
        System.out.println();
    }

    private static String display(Scanner in, ArrayList list)
    {
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print (i.e. display) the list");
        System.out.println("Q – Quit the program");
        for (int i=0; i<list.size();i++)
        {
            System.out.println((i+1) + ". " + list.get(i));
        }
        System.out.println();
        return SafeInput.getRegExString(in,"Enter your choice","[AaDdPpQq]");
    }
}