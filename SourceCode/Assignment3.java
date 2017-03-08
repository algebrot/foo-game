/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author Tom
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Makes all the pieces to play
        AI player1 = new AI();
         Human player2 = new Human();        //This creates a human player who can play from the console
        //AI player2 = new AI();
       
        ABoard Board = new ABoard();
        GameMaster DungeonMaster = new GameMaster();
        FooUserInterface Foointerface = new FooUserInterface();
        FooHistory GameState = new FooHistory();
        FooRules fRules = new FooRules();
        
        DungeonMaster.addPlayer(player1);
        DungeonMaster.addPlayer(player2);
        
        DungeonMaster.PlayGame(fRules, Foointerface, GameState, Board);
    
        
    }
    
}
