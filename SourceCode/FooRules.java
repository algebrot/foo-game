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
public class FooRules implements Rules {
    public boolean adjacent(Point2D point1, Point2D point2){
        if(point1.getX()==point2.getX()){
            if(point1.getY() == point2.getY()-1 || point1.getY() == point2.getY()+1){
                return true;
            }
            else{
                return false;
            }
        }
        else if(point1.getY()==point2.getY()){
            if(point1.getX() == point2.getX()-1 || point1.getX() == point2.getX()+1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public ArrayList<Point2D> adjList(Point2D point,ArrayList<Point2D> inputList){
    
    ArrayList<Point2D> tempInput = new ArrayList<>();
    tempInput.addAll(inputList);
    ArrayList<Point2D> adjacentList = new ArrayList<>();
    adjacentList.add(point); //Should I add the begging point to the adjacent list?
    int counter = 0;
    while (counter <= inputList.size()*100){
       ArrayList<Point2D> tempTempInput = tempInput;
       ArrayList<Point2D> tempAdjacentList = adjacentList;
       outerloop:
            for(Point2D point1: tempAdjacentList){
                for(Point2D point2: tempTempInput){
                    if(adjacent(point1,point2)){
                        adjacentList.add(point2);
                        tempInput.remove(point2);
                        //counter +=1;
                        break outerloop;
                    }
                }
            }
            counter+=1;
    }
    //adjacentList.remove(point); This line removed the piece to check. Caused bugs earlier
    return adjacentList;
    }
    
    
    public boolean checkWin(ArrayList<Object> Gamestate){
      
    FooHistory currentGameState = (FooHistory) Gamestate.get(0);
    int turncount = currentGameState.getTurnCount();
    ArrayList<Point2D> tempArray = new ArrayList<>();
    if(turncount%2==1){     //Player 1's turn
        ArrayList<Point2D> player1moves = currentGameState.getCurrentState().get(0); 
        tempArray = player1moves;
    }
    else{ // Player 2's turn
        ArrayList<Point2D> player2moves = currentGameState.getCurrentState().get(1); 
        tempArray = player2moves;
    }
        for(int i=0;i<tempArray.size();i++){
            
            ArrayList<Point2D> toCheck= adjList(tempArray.get(i),tempArray);//Gets adjacent point list starting from the first in the array
            
            boolean touchingLeft = false;
            boolean touchingRight = false;
            boolean touchingTop = false;
            boolean touchingBottom = false;
            for(Point2D point: toCheck){
                if(point.getX()==0 && point.getY()==0){ //(0,0) or bottom left case
                    touchingBottom = true;
                    touchingLeft = true;
                }
                else if(point.getX()==0 && point.getY()==4){ //(0,4) or top left case
                    touchingTop = true;
                    touchingLeft = true;
                }
                else if(point.getX()==4 && point.getY()==4){ //(4,4) or top right case
                    touchingTop = true;
                    touchingRight = true;
                        
                }
                else if(point.getX()==4 && point.getY()==0){ //(4,0) or top right case
                    touchingBottom = true;
                    touchingRight = true;
                        
                }
                else if(point.getX()==0){ //touching left side
                    touchingLeft=true;
                }
                else if(point.getX()==4){ //touching right side
                    touchingRight=true;
                }
                else if(point.getY()==0){ //touching bottom
                    touchingBottom=true;
                }
                else if(point.getY()==4){ //touching top
                    touchingTop=true;
                }
                
            }
        if(touchingLeft && touchingRight){
            return true;
        }
        else if(touchingTop && touchingBottom){
            return true;
        }
        
        }
        return false;
    
    
    }
    public boolean legalMove(ArrayList<Point2D> inputMove,ArrayList<Object> Gamestate){
        //Because the board takes in input, we dont have to deal with the out of
        //bounds case
        FooHistory currentGameState = (FooHistory) Gamestate.get(0);
        ArrayList<Point2D> player1moves= currentGameState.getCurrentState().get(0);
        ArrayList<Point2D> player2moves= currentGameState.getCurrentState().get(1);
        //System.out.println("Player1 moves in FooRules: "+ player1moves);
        
        if(inputMove.size()==1){
            for(ArrayList<Point2D> array: currentGameState.getCurrentState()){
                for(Point2D point:array){
                    if(inputMove.get(0).getX()==point.getX() && inputMove.get(0).getY()==point.getY()){
                        System.out.println("Ilegal Move");
                        return false;
                    }
                }
            }
        return true;
        }
        else{//Deals with moving a piece to take pieces
            if(adjacent(inputMove.get(0),inputMove.get(1))){//Makes sure the two input moves are adjacent
                if(currentGameState.getTurnCount()%2==1){ //Player 1's turn
                    for(Point2D point:player2moves){
                        if(point.getX()==inputMove.get(1).getX() && point.getY()==inputMove.get(1).getY()){
                            return true;
                        }
                    }
                }
                if(currentGameState.getTurnCount()%2==0){//Player 2's turn
                    for(Point2D point:player1moves){
                        if(point.getX()==inputMove.get(1).getX() && point.getY()==inputMove.get(1).getY()){
                            return true;
                        }
                    }
                }
            }
        System.out.println("Ilegal Move");    
        return false;    
        }
        
    }
    
    
}
