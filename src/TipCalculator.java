import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Tip Diner!");
        System.out.print("What is your name?");
        String name = scan.nextLine();
        System.out.print("Hello, " + name + " how many people are in your group?");
    }
}