/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import javafx.geometry.Point2D;

/**
 *
 * @author Tom
 */
public class Human implements Player {
    @Override
    public ArrayList<Point2D> move(ArrayList<Object> input){
    //Supposed to take an array of ints and spit out appropriate Point2D object
    ArrayList<Integer> tempArray = new ArrayList<>(); 
    ArrayList<Point2D> returnArray = new ArrayList<>();
    for(Object inputObject: input){
        int intInArray = (int) inputObject;
        tempArray.add(intInArray);
    } 
    if(tempArray.size()==2){ //Case where a new piece is placed on the board
       int x=tempArray.get(0);
       int y=tempArray.get(1);
       Point2D pointToAdd = new Point2D(x,y);
       returnArray.add(pointToAdd);
       return returnArray;
       
    }
    else{ //Case where a piece is being taken
         int x1=tempArray.get(0);
         int y1=tempArray.get(1);
         int x2 = tempArray.get(2);
         int y2 = tempArray.get(3);
         Point2D originalPieceLocation = new Point2D(x1,y1);
         Point2D newPieceLocation = new Point2D(x2,y2);
         returnArray.add(originalPieceLocation);
         returnArray.add(newPieceLocation);
         return returnArray;
    }
        
    }
}
