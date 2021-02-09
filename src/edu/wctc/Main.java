package edu.wctc;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String carby = "carby";
        String tomatoey = "tomatoey";
        String cheesy = "cheesy";
        String evens = "evens";
        String primes = "primes";
        String fibonnacis = "fibonnacis";

        VennDiagram<String> foodDiagram = new VennDiagram<>(carby, tomatoey, cheesy);
        VennDiagram<Integer> numberDiagram = new VennDiagram<>(evens, primes, fibonnacis);

        foodDiagram.add("Croissant", carby);
        foodDiagram.add("Roll", carby);
        foodDiagram.add("Toast", carby);
        foodDiagram.add("Grilled Cheese", carby, cheesy);
        foodDiagram.add("Mac and Cheese", carby, cheesy);
        foodDiagram.add("Cheese and Crackers", carby, cheesy);
        foodDiagram.add("Bagel and Cream Cheese", carby, cheesy);
        foodDiagram.add("Spaghetti Marinara", carby, tomatoey);
        foodDiagram.add("Tomato Sandwich", carby, tomatoey);
        foodDiagram.add("Lasagna", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Soup and Goldfish Crackers", carby, tomatoey, cheesy);
        foodDiagram.add("Pizza Margherita", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato and Mozzarella Sandwich", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Slices", tomatoey);
        foodDiagram.add("Tomato Wedges", tomatoey);
        foodDiagram.add("Grape Tomatoes", tomatoey);
        foodDiagram.add("Caprese Salad", tomatoey, cheesy);
        foodDiagram.add("Greek Salad", tomatoey, cheesy);
        foodDiagram.add("Mozzarella Sticks", cheesy);
        foodDiagram.add("String Cheese", cheesy);
        foodDiagram.add("Cheese Cubes", cheesy);
        foodDiagram.add("Fresh Mozzarella", cheesy);

        /**Number Diagram additions - fib is 0 1 2 3 5 8 13**/
        numberDiagram.add(1, primes, fibonnacis);
        numberDiagram.add(2, evens, primes);
        numberDiagram.add(3, primes, fibonnacis);
        numberDiagram.add(4, evens);
        numberDiagram.add(5, primes, fibonnacis);
        numberDiagram.add(6, evens);
        numberDiagram.add(7, primes);
        numberDiagram.add(8, evens, fibonnacis);
        numberDiagram.add(9);
        numberDiagram.add(10, evens);

        /**Number diagram methods**/
        //prime OR even
        System.out.println(numberDiagram.unionOf(primes, evens));
        //prime AND fib
        System.out.println(numberDiagram.intersectionOf(primes, fibonnacis));
        //odd AND fib. Same as fib but not even
        System.out.println(numberDiagram.complementOf(fibonnacis, evens));
        //even AND prime AND fib. Should be null because you can't have an even prime
        System.out.println(numberDiagram.diagramCenter());

        /**Food diagram methods**/
        // carby OR tomatoey
        System.out.println(foodDiagram.unionOf(carby, tomatoey));
        // tomatoey AND cheesy
        System.out.println(foodDiagram.intersectionOf(tomatoey, cheesy));
        // cheesy but NOT carby
        System.out.println(foodDiagram.complementOf(cheesy, carby));
        // all three
        System.out.println(foodDiagram.diagramCenter());
    }
}