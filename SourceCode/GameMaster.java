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
public class GameMaster {
    
    ArrayList<Player> playersInGame = new ArrayList<>();
    public void addPlayer(Player playerToAdd){ 
        playersInGame.add(playerToAdd);
    }
    
    public void PlayGame(FooRules Rules, UserInterface FooUserInterface, FooHistory Gamestate, ABoard Board){
        ArrayList<Point2D> move1 = new ArrayList<>();
        boolean gameFinished = false;
        boolean legalMove = false;
        FooUserInterface FooUserInterfaces = (FooUserInterface) FooUserInterface;
        ArrayList<Object> currentPlayerHolder= new ArrayList<>();
        ArrayList<Object> GameStateHolder = new ArrayList<>();
        while(!gameFinished){
            
           
            System.out.println("Current Turn Count:  "+Gamestate.getTurnCount());
            
            if (Gamestate.getTurnCount()%2==1){     //Player 1 turn
                currentPlayerHolder.add(playersInGame.get(0));
               
            }
            else{//player 2 turn
                
                currentPlayerHolder.add(playersInGame.get(1));
               
            }
                while(!legalMove){ 
                    move1 = FooUserInterfaces.requestMove(currentPlayerHolder, Gamestate);
                    GameStateHolder.add(Gamestate);
                    
                    if(Rules.legalMove(move1,GameStateHolder)){
                       Gamestate.addMove(move1);
                        update(move1,Gamestate,Board);
                        legalMove = true;
                    }  
                    
                    
                    
                }
                legalMove = false;
              
                GameStateHolder.clear();
                GameStateHolder.add(Gamestate);
                
                if(FooHistory.p1PlaceCount==21 || FooHistory.p1PlaceCount==21){ //If 21 pieces are played
                    if (Gamestate.getCurrentState().get(0).size() > Gamestate.getCurrentState().get(1).size()){ //Player 1 has more pieces
                        System.out.println("Player 1 WINS!!!!");
                         gameFinished = true;
                    }
                    else { //Player 2 has more pieces
                        System.out.println("Player 2 WINS!!!!");
                         gameFinished = true;
                    }
                }
                
                if(Rules.checkWin(GameStateHolder)){
                   
                     if(Gamestate.getTurnCount()%2==1){
                         System.out.println("Player 1 WINS!!!!");
                         gameFinished = true;
                     }
                     else if(Gamestate.getTurnCount()%2==0){
                         System.out.println("Player 2 WINS!!!!");
                         gameFinished = true;
                     }
                     
                 }
                 
                 
                 GameStateHolder.clear();//Prevents the GameState from building up in the container.
                 currentPlayerHolder.clear();
                 //Only one should be there at a time
        }    
    }
    
    public void update(ArrayList<Point2D> inputMove, FooHistory GameState, ABoard Board){
        //Should update the gamestate
        //Should print out the board
        //GameState.addMove(inputMove);
        if(inputMove.size()==2){
            Board.deleteFromBoard(inputMove.get(0));
                            
        }
                        
        Board.updateBoard(GameState.getCurrentState());
        Board.drawBoard();
    }
    
    
    
}
