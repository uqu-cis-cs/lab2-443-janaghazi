package edu.uqu.cs;
/*
 * Lab 2 
 * CS 1312
 */

/*
* Make sure to complete and submit your lab
*/
import java.util.Scanner;

public class Garage{

    /************ Part 1 **************/
    /**
     * Decalre an instance variable named cars
     * as an array of Car type
     * it should be of size 3
     * Make sure its private
     * Syntax:
     * private classType [] varName = new classType[size];
     *
     */

    private Car [] cars = new Car [3];


    /************ Part 2 **************/
    /**
     * Decalre a static/class variable named countCars
     * Make sure its public
     * you could initialize it to 0
     * Syntax:
     * public dataType varName= value;
     *
     */

    public static int countCars = 0;

    /************ Part 3 **************/
    /**
     * Define a default constructor to create
     * all the elements of cars
     * 
     * Use loop to create them as follows:
     * Syntax:
     * public className (){
     * 	   for(int i=0; i<arrayName.length; i++){
     *         arrayName[i]= new arrayClassName();
     *     }
     *}
     */

    public Garage() {
        for (int i = 0; i<cars.length; i++) {
            cars [i] = new Car();
        }
    }

    /************ Part 4 **************/
    /**
     * Define addCar(String parameter) that adds a new car (by model) to the garage 
     * and set its flag to true; 
     * hint: you must check if the car has not been added before to the list of cars 
     * and it should be added to the car list by using the static variable countCars! 
     * also, change the status of the instance variable inOutGarage to true 
     * by calling method moveCarIn() of class Car
     * Don’t forget to increase countCars’s value by one
     * Note: method returns NO data
     * Syntax:
     * public void methodName(String m)
     */

    public void addCar(String modelName) {    
       
        boolean findCar =false; // initial value 

            for(int i =0; i<countCars; i++)  {
                //if the car is inside = move car in
                if (cars[i].getModel().equals(modelName)) {
                    findCar =true;
                    cars[i].moveCarIn();
                }
            }

            // IF THE CAR WASNT FOUND
            if(!findCar) {
                if(countCars<cars.length)
                {
                Car x = new Car(); // creating a new object
                x.setModel(modelName); // giving it a name
                cars[countCars]= x; // givving it a place in the array
                
                cars[countCars].moveCarIn(); // setting a value for the flag
                countCars++;    
                }
                else
                {
                    System.out.println("The Garage is Full, no room for more cars");
                }
            }
    }

    /************ Part 5 **************/
    /**
     * Define moveOut(String) that moves the car (by model) out of the garage; 
     * hint you must first search if the car is in the list of cars, 
     * then use moveCarOut () method of class Car
     * Note: method returns NO data
     * Syntax:
     * public void methodName(String m)
     *
     */

    public void moveOut(String m) {   
        for (int i = 0; i < countCars; i++) {
            if (cars[i].getModel().equals(m)) {
                cars[i].moveCarOut();
            }
        } 
    }


    /************ Part 6 **************/
    /**
     * Define moveOut(String) that moves the car (by model) into the garage; 
     * hint you must first search if the car is in the list of cars, 
     * then use moveCarIn () method of class Car;
     * Note: method returns NO data
     * Syntax:
     * public void methodName(String m)
     *
     */

    public void moveIn(String m) { 
        for (int i = 0; i < countCars; i++) {
            if (cars[i].getModel().equals(m)) {
                cars[i].moveCarIn();
            }
        }       
    }


    /************ Part 7 **************/
    /**
     * Define listCars() to display/list all the cars in the garage;
     * Note: method returns NO data
     * Hint: use loop and methods of class Car to access private data members
     * Syntax:
     * public void methodName(String m)
     *
     */

    public void listCars() {   
        System.out.println("All cars in the garage are:");
            for (int i =0; i<countCars; i++) {
                if (cars[i].getInOutGarage()) {
                    System.out.println("car " + (i+1) + ": " + cars[i].getModel());                    
                }                 
            System.out.println();
            }
    }

}