/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class FooUserInterface implements UserInterface {
    public ArrayList<Point2D> requestMove(ArrayList<Object> player, FooHistory GameState){
        ArrayList<Object> outMoves = new ArrayList(); 
        if(player.get(0) instanceof Human){
            Human human = (Human) player.get(0); 
             Scanner user_input = new Scanner(System.in);
             
                 boolean correctInput = false;
                 String moveType = null;
                 while(!correctInput){ //Ensures the user enters the correct move type
                    if(GameState.getTurnCount()%2==1){
                    System.out.println("Player 1 please select your move type (move or place): ");
                    moveType = user_input.next( );
                    }
                    else{
                        System.out.println("Player 2 please select your move type (move or place): ");
                        moveType = user_input.next( );
                    }
                    if(moveType.equalsIgnoreCase("move") || moveType.equalsIgnoreCase("place")){
                        correctInput=true;
                    }
                 }
                 int xLoc=10;
                 int yLoc=10;
                 
                 if(moveType.equalsIgnoreCase("place")){
                     while(xLoc>6 || xLoc<0 || yLoc>6 || yLoc<0){//Ensures inputs are between 0 and 4
                     System.out.println("Please enter in the x location (between 0 and 4) of your move: ");
                     xLoc = user_input.nextInt();
                     System.out.println("Please enter in the y location (between 0 and 4) of your move: ");
                     yLoc = user_input.nextInt();
                     }
                     outMoves.add(xLoc);
                     outMoves.add(yLoc); 
                     return human.move(outMoves);
                 }
                 
                 else{ //Imples the move type is move
                     int x1=10;
                     int y1=10;
                     int x2=10;
                     int y2=10;
                     while(x1>6 || x1<0 || y1>6 || y1<0 || x2>6 && x2<0 || y2>6 || y2<0){//Ensures inputs are between 0 and 4
                     System.out.println("Please enter in the x location (between 0 and 4) of the piece to move:  ");
                     x1 = user_input.nextInt();
                     System.out.println("Please enter in the y location (between 0 and 4) of the piece to move: ");
                     y1 = user_input.nextInt();
                     System.out.println("Please enter in the x location (between 0 and 4) of the new piece location  ");
                     x2 = user_input.nextInt();
                     System.out.println("Please enter in the y location (between 0 and 4) of the new piece location ");
                     y2 = user_input.nextInt();
                     }
                     outMoves.add(x1);
                     outMoves.add(y1); 
                     outMoves.add(x2);
                     outMoves.add(y2); 
                     return human.move(outMoves);
                     
                 }
                 
             }  
                 
            
             
             
         
         else  { //(player instanceof AI)
             AI currentAI = (AI) player.get(0);
             
             ArrayList<Object> GameStateArray = new ArrayList<>();
             GameStateArray.add(GameState);
             return currentAI.move(GameStateArray);
         }
    }
}
