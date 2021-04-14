/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smoot
 */
public class Human {
    private String gender;
    private double currentWeight;
    private double desiredWeight;
    private int height;
    private int age;
    private int activity;
    
    public Human(String gender, double currentWeight, double desiredWeight, int height, int age, int activity) {
        this.gender = gender;
        this.currentWeight = currentWeight;
        this.desiredWeight = desiredWeight;
        this.height = height;
        this.age = age;
        this.activity = activity;
    }
    
    public double calculateTDEE() {
        //calculate TDEE
        double tdee;
        if (gender.equals("m")) {
            tdee = ((10 * currentWeight) + (6.25 * height) - (5 * age) + 5);
        } else {
            tdee = ((10 * currentWeight) + (6.25 * height) + (5 * age) - 161);
        }

        //approximate activity level
        switch (activity) {
            case 1:
                tdee = tdee * 1.2;
                break;
            case 2:
                tdee = tdee * 1.35;
                break;
            case 3:
                tdee = tdee * 1.55;
                break;
            default:
                break;
        }
        return tdee;
        
    }
    
    public double getCurrentWeight() {
        return this.currentWeight;
    }
    
    public double getDesiredWeight() {
        return this.desiredWeight;
    }
    
}
