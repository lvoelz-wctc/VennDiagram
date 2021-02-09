package edu.wctc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class VennDiagram<T> {
    public String circleOne;
    public String circleTwo;
    public String circleThree;

    Set<T> setOne = new HashSet<T>();
    Set<T> setTwo = new HashSet<T>();
    Set<T> setThree = new HashSet<T>();

    /**VennDiagram class constructor, accepts three strings for circleX labels**/
    public VennDiagram (String circleOne, String circleTwo, String circleThree){
        this.circleOne = circleOne;
        this.circleTwo = circleTwo;
        this.circleThree = circleThree;
    }

    //using the varargs "String..." stores labels in an array
    //currently this isn't adding anything past the first label
    public void add(T item, String... labels) {
        for (String i : labels) {
            if (i.equals(circleOne)){
                setOne.add(item);
            }
            if (i.equals(circleTwo)){
                setTwo.add(item);
            }
            if (i.equals(circleThree)){
                setThree.add(item);
            }
        }
    }

    /**Returns items in center of diagram**/
    public Set<T> diagramCenter(){
        Set<T> allThree = new HashSet<T>(setOne);
        allThree.retainAll(setTwo);
        allThree.retainAll(setThree);
        return allThree;
    }

    /**All items only in first and not in second**/
    public Set<T> complementOf(String first, String second){
        Set<T> complementSet = getCircleForLabel(first);
        complementSet.removeAll(getCircleForLabel(second));
        return complementSet;
    }

    /**All items in EITHER first or second set**/
    public Set<T> unionOf(String first, String second){
        Set<T> unionSet = getCircleForLabel(first);
        unionSet.addAll(getCircleForLabel(second));
        return unionSet;
    }

    /**All items in BOTH first and second set**/
    public Set<T> intersectionOf(String first, String second){
        Set<T> intersectionSet = getCircleForLabel(first);
        intersectionSet.retainAll(getCircleForLabel(second));
        return intersectionSet;
    }

    /**Given a label, return associated set. used in this class only**/
    private Set<T> getCircleForLabel(String label){
        Set<T> desiredSet = new HashSet<T>();

        if (label.equals(circleOne)){
            desiredSet.addAll(setOne);
        }
        else if (label.equals(circleTwo)){
            desiredSet.addAll(setTwo);
        }
        else if (label.equals(circleThree)){
            desiredSet.addAll(setThree);
        }
        return desiredSet;
    }
}
