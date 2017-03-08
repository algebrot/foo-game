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
public class FooHistory implements History {
    public static int turncount=1;
    public static ArrayList<Point2D> player1moves = new ArrayList<>();
    public static ArrayList<Point2D> player2moves = new ArrayList<>();
    public static ArrayList<ArrayList<Point2D>> allmoves = new ArrayList<>();
    public static int p1PlaceCount = 0;
    public static int p2PlaceCount = 0;
   
 
    public void addMove(ArrayList<Point2D> inputMove){
        
        int sameLocationInArray = 0;
       
        
        if (turncount%2==1){   //Player 1's turn (1%2==1)
            
            if(inputMove.size()==2){//Deals with moving a piece to take another
                
            
            for(int i=0;i<player2moves.size(); i++){ 
                if(inputMove.get(1).getX()==player2moves.get(i).getX() && inputMove.get(1).getY()==player2moves.get(i).getY()){
                    sameLocationInArray = i;
                   
                }
            }
                player1moves.remove(inputMove.get(0));
                player1moves.add(inputMove.get(1));
                player2moves.remove(sameLocationInArray);
            }
            
            else{ //Placing a piece
                player1moves.add(inputMove.get(0));
                p1PlaceCount +=1;
                
            }
            
            }
        
        else if(turncount%2==0){ //Players 2's turn
            if(inputMove.size()==2){//Deals with moving a piece to take another
                
            
            for(int i=0;i<player1moves.size(); i++){ 
                if(inputMove.get(1).getX()==player1moves.get(i).getX() && inputMove.get(1).getY()==player1moves.get(i).getY()){
                    sameLocationInArray = i;
                   
                }
            }
                player2moves.remove(inputMove.get(0));
                player2moves.add(inputMove.get(1));
                player1moves.remove(sameLocationInArray);
            }
            
            else{ //Deals with placing a piece
                player2moves.add(inputMove.get(0));
                p2PlaceCount +=1;
            }
            
            }
        turncount+=1; //Turncount starts at 1
        
            
        }
        
        
     
    
    public ArrayList<ArrayList<Point2D>> getCurrentState(){
        allmoves.clear();
        allmoves.add(player1moves);
        allmoves.add(player2moves);
        return allmoves;
        
    }
    
    public int getTurnCount(){
        return turncount;
    }
    
}
