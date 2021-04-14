
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author smoot
 */
public class UserInterface {

    private Human user;
    
    public void start() {
        Scanner scanner = new Scanner(System.in);

        //intro
        System.out.println("---WELCOME---");
        System.out.println("     to");
        System.out.println("---GAINSMAXX---");
        System.out.println("");

        //verify gender
        String gender = "";
        while (true) {
            System.out.println("Input sex (m/f)");
            gender = scanner.nextLine();
            if (gender.equals("m") || gender.equals("f")) {
                break;
            } else {
                System.out.println("ERROR: Please type 'm' for male or 'f' for female.");
            }
        }
        //other user inputs
        System.out.println("Input current weight (kg):");
        double currentWeight = Double.valueOf(scanner.nextLine());
        System.out.println("Input DESIRED weight (kg):");
        double desiredWeight = Double.valueOf(scanner.nextLine());
        System.out.println("Input current height (cm):");
        int height = Integer.valueOf(scanner.nextLine());
        System.out.println("How active are you?");
        System.out.println("1 = sedentary, maybe some lifting/walking");
        System.out.println("2 = some cardio, e.g. 5k run 4-5x a week");
        System.out.println("3 = pretty active, regular 10ks or higher");

        int activity = 0;
        while (true) {
            System.out.println("Please input 1, 2 or 3.");
            activity = Integer.valueOf(scanner.nextLine());
            if (activity == 1 || activity == 2 || activity == 3) {
                break;
            }
        }
        System.out.println("Finally, enter your age (years):");
        int age = Integer.valueOf(scanner.nextLine());

        //create human
        user = new Human(gender, currentWeight, desiredWeight, height, age, activity);
    }

    public void output() {
        //calculate weight gain timescale
        double weightDifference = (user.getDesiredWeight() - user.getCurrentWeight());
        double weightTime = (weightDifference * 7) / 0.5;
        double daysToWeeks = weightTime / 7;

        //outputs
        System.out.println("very good. You are currently: " + user.getCurrentWeight() + " kilos. You want to gain " + weightDifference + " kilos.");
        System.out.println("To gain weight at a healthy rate, you want to eat at most a +500 daily surplus above what you burn.");
        System.out.println("For you, that would be " + (user.calculateTDEE() + 500) + " calories per day.");
        System.out.println("It should take around " + weightTime + " days (" + daysToWeeks + " weeks) to gain " + weightDifference + " kilos.");
        System.out.println("You should gain around 0.5kg a week at this rate, although don't be afraid to adjust as you go.");
        System.out.println("now ---GAINSMAXX--- and make yourself proud.");
    }

}
