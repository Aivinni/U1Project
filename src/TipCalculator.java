import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Declaring Variables
        boolean tip = true;
        boolean run = true;
        String item;
        String items = "";
        int numInGroup;
        int percentage = 0;
        double totalCost = 0.0;
        double costAfterTip;
        double priceItem;
        int i;
        String itemToPrint;
        String letter;
        int indexPrevSpace = 0;

        // Getting User inputs
        System.out.println("Welcome to Tip Diner!");
        System.out.println("What is your name? ");
        String name = scan.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("How many people are in your group? ");
        numInGroup = scan.nextInt();
        scan.nextLine();
        System.out.println("What country are you in? ");
        String country = scan.nextLine();
        if (country.equalsIgnoreCase("Japan") ||
                country.equalsIgnoreCase("China") ||
                country.equalsIgnoreCase("French Polynesia") ||
                country.equalsIgnoreCase("Korea") ||
                country.equalsIgnoreCase("Hong Kong") ||
                country.equalsIgnoreCase("Switzerland") ||
                country.equalsIgnoreCase("Australia") ||
                country.equalsIgnoreCase("Belgium") ||
                country.equalsIgnoreCase("Brazil") ||
                country.equalsIgnoreCase("Denmark") ||
                country.equalsIgnoreCase("Estonia") ||
                country.equalsIgnoreCase("New Zealand")){
            tip = false;
        }
        // freestyle, if user is in one of the countries where tipping is not the norm, this will print
        if (!tip) {
            System.out.println("Tipping is not required in these countries and may even be considered offensive.");
        }
        // If anything else, this will print and ask for tip percentage
        if (tip) {
            System.out.println("What is the tip percentage? ");
            percentage = scan.nextInt();
            scan.nextLine();
        }
        // Getting items and prices
        while (run) {
            System.out.println("Enter your item (-1 to stop, -1 will not be recorded)");
            item = scan.nextLine();
            if (!item.equals("-1")) {
                items += item + " ";
            }
            System.out.println("Enter price of item (-1 again to stop)");
            priceItem = scan.nextDouble();
            scan.nextLine();
            if (!(priceItem == -1)) {
                totalCost += priceItem;
            } else {
                run = false;
            }
        }
        // Doing the EC WITHOUT using google
        itemToPrint = "";
        for (i = 0; i < items.length(); i++) {
            letter = items.substring(i, i + 1);
            if (letter.equals(" ")) {
                itemToPrint += items.substring(indexPrevSpace, i) + "\n";
                indexPrevSpace = i;
            }
        }
        // HAHA I did it without using arrays or split(). I googled Java arrays and I have come to the conclusion Java Arrays are a crime against humanity.
        // Receipt
        System.out.println("------------------Receipt------------------");
        System.out.println("Total Bill before tip: " + totalCost);
        System.out.println("Total Percentage: " + percentage + "%");
        costAfterTip = totalCost + (totalCost * ((double) percentage / 100));
        System.out.println("Total Tip: " + (costAfterTip - totalCost));
        System.out.println("Total bill with tip: " + costAfterTip);
        System.out.println("Per person cost before tip: " + (totalCost / numInGroup));
        System.out.println("Tip per person: " + ((costAfterTip / numInGroup) - (totalCost / numInGroup)));
        System.out.println("Per person cost after tip " + (costAfterTip / numInGroup));
        System.out.println("-------------------------------------------");
        System.out.println(itemToPrint);
    }
}